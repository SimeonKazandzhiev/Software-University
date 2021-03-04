package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computer;
    private Computer computerTwo;


    @Before
    public void setUp(){
        computerManager = new ComputerManager();
        computer = new Computer("DELL","BV234",300.00);
        computerTwo = new Computer("ASUS","Rog",500.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers(){

        computerManager.getComputers().remove(0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullAdd(){

        computerManager.addComputer(null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingComputer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void testAddWorksCorrectly(){
        computerManager.addComputer(computer);
        assertEquals(1,computerManager.getCount());

    }
    //For get method start first with two test for validate params

    @Test(expected = IllegalArgumentException.class)
    public void testGetWithNullManufacturer(){
        computerManager.getComputer(null,"test");

    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetWithNullModel(){
        computerManager.getComputer("Samsung",null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetWithNoneExistingComputer(){
        computerManager.getComputer(computer.getManufacturer(),computer.getModel());

    }
    @Test
    public void testGetReturnsCorrectComputer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computerTwo);
        Computer returnedComputer = computerManager.getComputer(this.computer.getManufacturer(), this.computer.getModel());

        assertNotNull(returnedComputer);

        assertEquals(computer.getManufacturer(),returnedComputer.getManufacturer());
        assertEquals(computer.getModel(),returnedComputer.getModel());


    }

    @Test
    public void testGetByManufacturer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computerTwo);

        List<Computer> computersByManufacturer = computerManager.getComputersByManufacturer(computer.getManufacturer());
        assertNotNull(computersByManufacturer);
        assertEquals(computersByManufacturer.get(0).getManufacturer(),computer.getManufacturer());
    }
}