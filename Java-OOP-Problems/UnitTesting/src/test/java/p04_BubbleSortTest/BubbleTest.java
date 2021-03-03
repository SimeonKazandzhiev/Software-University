package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BubbleTest {

    @Test
    public void testSort(){

        int[] arr = {20,40,53,68,1,3,8,12,-12};

        Bubble.sort(arr);

        int[] expectedSort = {-12,1,3,8,12,20,40,53,68};

        for (int i = 0; i < expectedSort.length; i++) {
            assertEquals(arr[i],expectedSort[i]);
        }

    }

}