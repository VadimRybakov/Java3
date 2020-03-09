package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Tests {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 5, 7, 8, 4, 20, 31, 19},
                {2, 4, 4, 9, 2, 3},
                {9, 1, 8, 18, 29, 4},
                {}
        });
    }
    private int[] arr;
    public Tests(int[] arr){
        this.arr = arr;
    }
    private static ArraysMethods arraysMethods;

    @Before
    public void init(){
        arraysMethods = new ArraysMethods();
    }

    @Test
    public void testTailArr(){
        int[] resultArray = arraysMethods.tailArr(arr);
        System.out.println(Arrays.toString(resultArray));
    }

    @Test(expected = RuntimeException.class)
    public void checkException() {
        arraysMethods.tailArr(arr);
    }

    @Test
    public void testChekArr(){
        Assert.assertTrue(arraysMethods.checkArr(arr));
    }

    @After
    public void tearDown(){
        arraysMethods = null;
    }
}
