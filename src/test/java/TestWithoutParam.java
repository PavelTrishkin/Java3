import Lesson6.Task1;
import org.junit.Before;
import org.junit.Test;

public class TestWithoutParam {
    private Task1 task1;

    @Before
    public void startTest(){
        task1 = new Task1();
    }

    @Test(expected = RuntimeException.class)
    public void testNumsAfterFourException() {
        Task1.numsAfterFour(new int[]{0, 3, 7});
    }
}
