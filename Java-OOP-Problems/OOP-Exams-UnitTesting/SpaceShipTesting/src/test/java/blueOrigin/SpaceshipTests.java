package blueOrigin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    //Constructor
        //1. if the name is invalid (null)
    @Test(expected = NullPointerException.class)
    public void testIfReturnExWithNullParamForName(){
        Spaceship spaceship = new Spaceship(null,10);

    }
        //2. if the capacity is less than 0
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowExWithLessThanZeroCapacity(){
        Spaceship spaceship = new Spaceship("Apollo",-2);

    }
        //3. if the constructor create valid object
    @Test
    public void testConstructorIsCreatedProperly(){
        Spaceship spaceship = new Spaceship("Apollo",20);
        
    }
    //add method
    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowExWithFullCapacity(){
        Spaceship spaceship = new Spaceship("Apollo",3);
        Astronaut pesho = new Astronaut("Pesho",10.0);
        Astronaut gosho = new Astronaut("Gosho",10.0);
        Astronaut panaiot = new Astronaut("Panaiot",10.0);
        Astronaut milen = new Astronaut("Milen",40.0);

        spaceship.add(pesho);
        spaceship.add(gosho);
        spaceship.add(panaiot);
        spaceship.add(milen);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowExWithExistingAstronaut(){
        Spaceship spaceship = new Spaceship("Apollo",3);
        Astronaut pesho = new Astronaut("Pesho",10.0);
        Astronaut gosho = new Astronaut("Gosho",10.0);
        Astronaut panaiot = new Astronaut("Panaiot",10.0);

        spaceship.add(pesho);
        spaceship.add(gosho);
        spaceship.add(panaiot);
        spaceship.add(panaiot);

    }

    //remove method
    @Test
    public void testRemoveReturnAstrIsRemoved(){
        Spaceship spaceship = new Spaceship("Apollo",2);
        Astronaut pesho = new Astronaut("Pesho",10.0);
        Astronaut gosho = new Astronaut("Gosho",10.0);
        spaceship.add(pesho);
        spaceship.add(gosho);


        assertTrue(spaceship.remove(pesho.getName()));
    }
    @Test
    public void testRemoveReturnNullIfNonExistAstronaut(){
        Spaceship spaceship = new Spaceship("Apollo",2);
        Astronaut pesho = new Astronaut("Pesho",10.0);
        Astronaut gosho = new Astronaut("Gosho",10.0);
        spaceship.add(pesho);
        spaceship.add(gosho);

        assertFalse(spaceship.remove("ivan"));
    }
}
