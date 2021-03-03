package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5, 16, 20, 49};


    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    // Constructor method testing
    // 1 Return correct object
    @Test
    public void testConstructorCreateValidObject() throws OperationNotSupportedException {


        //First I check if the count of elements are as expected
        assertEquals(4, database.getElements().length);

        //Check if the elements from numbers are same like in database
        Integer[] databaseNumbers = database.getElements();
        for (int i = 0; i < databaseNumbers.length; i++) {
            assertEquals(databaseNumbers[i], NUMBERS[i]);
        }
    }

    // 2 Elements are more than 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExpIfMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    // 3 Elements are less than 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExpIfLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);

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

        database.add(30);
        //Check if the count are as expected after adding the element
        assertEquals(5, database.getElements().length);
        //Check if the added element is at the last index in the array
        assertEquals(Integer.valueOf(30), database.getElements()[4]);
    }

    //Remove method testing
    //1. If dont have elements in the array
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowExWhenEmptyData() throws OperationNotSupportedException {

        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();

    }

    //2. if the last element is removed
    @Test
    public void testRemoveMethodIfTheElementIsRemoved() throws OperationNotSupportedException {

        database.remove();
        assertEquals(3, database.getElements().length);
        assertEquals(Integer.valueOf(20), database.getElements()[2]);
    }


}