package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] DATA = {"X", "Y", "Z"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(DATA);
    }

    //Constructor
    //1. If the params are null
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowIfParamNull() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    //HasNext method
    @Test
    public void testHasNextReturnsCorrectBoolean() {
        //"X","Y","Z"

        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    //Move method
    @Test
    public void testMove() {
        //"X","Y","Z"
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());

    }
    //Print method
        //1. if the elements in the list are equal to zero
    @Test(expected = IllegalStateException.class)
    public void testPrintWithZeroElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

        //2. if we have elements in the list
    @Test
    public void testPrintWorksCorrect(){
        int index = 0;
        while (listIterator.hasNext()){
            assertEquals(DATA[index],listIterator.print());
            index++;
            listIterator.move();
        }

    }
}