import Lesson6.Task2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{7, 6, 5, 4, 9, 5, 6, 7}, true},
                {new int[]{1, 2, 2, 3, 1, 7}, true},
                {new int[]{2, 2, 3}, false},
                {new int[]{0, 2, 9, 9, 2, 3}, false}
        });
    }

    private int[] in;
    private boolean out;

    public TestTask2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Task2  task2;

    @Before
    public void startTest(){
        task2 = new Task2();
    }

    @Test
    public void testSearchNumFour(){
        Assert.assertEquals(Task2.searchNumFour(in), out);
    }
}
