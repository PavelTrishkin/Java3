package Lesson7;

public class ClassForTest {

    @BeforeSuite
    public void start(){
        System.out.println("Init");
    }

    @Test(priority = 4)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(priority = 10)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test()
    public void test4(){
        System.out.println("Test 4");
    }

    @Test()
    public void test5(){
        System.out.println("Test 5");
    }

    @AfterSuite
    public void anyMethod(){
        System.out.println("Not test");
    }

    @AfterSuite
    public void stop(){
        System.out.println("Test stopped");
    }


}
