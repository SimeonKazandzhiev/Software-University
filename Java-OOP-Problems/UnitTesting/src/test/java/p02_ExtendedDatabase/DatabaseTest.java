package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Person[] PEOPLE =
            {new Person(1,"First"),new Person(2,"Second")
            ,new Person(3,"Third"),new Person(4,"Fourth")};


    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    // Constructor method testing
    // 1 Return correct object
    @Test
    public void testConstructorCreateValidObject() throws OperationNotSupportedException {


        //First I check if the count of elements are as expected
        assertEquals(4, database.getElements().length);

        //Check if the elements from numbers are same like in database
        Person[] databaseNumbers = database.getElements();
        for (int i = 0; i < databaseNumbers.length; i++) {
            assertEquals(databaseNumbers[i], PEOPLE[i]);
        }
    }

    // 2 Elements are more than 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExpIfMoreThan16Elements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
         new Database(people);
    }

    // 3 Elements are less than 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExpIfLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);

    }

    // Add method testing
    //1. if the passed element is null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodWhenElementPassedIsNull() throws OperationNotSupportedException {

        database.add(null);

    }

    //2. if the element is successfully added
    @Test
    public void testAddMethodIfAddSuccessfully() throws OperationNotSupportedException {

        database.add(new Person(5,"Fifth"));
        //Check if the count are as expected after adding the element
        assertEquals(5, database.getElements().length);
        //Check if the added element is at the last index in the array
        assertEquals(5, database.getElements()[4].getId());
        assertEquals("Fifth", database.getElements()[4].getUsername());

    }

    //Remove method testing
    //1. If dont have elements in the array
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowExWhenEmptyData() throws OperationNotSupportedException {

        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();

    }

    //2. if the last element is removed
    @Test
    public void testRemoveMethodIfTheElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        assertEquals(3, database.getElements().length);
        assertEquals(3, database.getElements()[2].getId());
        assertEquals("Third", database.getElements()[2].getUsername());
    }
    //4. Test findByUsername
        //1. Param given is null
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameReturnsNullIfParamIsNull() throws OperationNotSupportedException {
       database.findByUsername(null);
    }
        //2. if are not people(or the list is only with null elements)
    @Test(expected =OperationNotSupportedException.class)
    public void testFindByUsernameThrowIfEmptyData() throws OperationNotSupportedException {
        database = new Database(null,null,null);
        database.findByUsername("First");

    }

        //3. if we dont find exactly 1 username
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNotEqualToOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");

    }
        //4. find the person by given username
    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        assertEquals(1,resultPerson.getId());
        assertEquals("First",resultPerson.getUsername());
    }

    //5. Test findById
    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        assertEquals(1,resultPerson.getId());
        assertEquals("First",resultPerson.getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdNotEqualToOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(2);

    }
    @Test(expected =OperationNotSupportedException.class)
    public void testFindByIdThrowIfEmptyData() throws OperationNotSupportedException {
        database = new Database(null,null,null);
        database.findById(2);

    }

}