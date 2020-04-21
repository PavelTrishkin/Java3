import Lesson6.Task1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class TestTask1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{7, 6, 5, 4, 9, 5,6,7}, new int[]{9,5,6,7}},
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 2, 2, 3, 4, 1}, new int[]{1}},
                {new int[]{1, 2, 4, 4, 2, 3}, new int[]{2, 3}}
        });
    }

    private int[] in;
    private int[] out;

    public TestTask1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private Task1 task1;

    @Before
    public void starTest(){
        task1 = new Task1();
    }

    @Test
    public void testNumsAfterFour(){
        Assert.assertArrayEquals(out, Task1.numsAfterFour(in));
    }

}
