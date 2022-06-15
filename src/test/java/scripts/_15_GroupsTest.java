package scripts;

import org.testng.annotations.Test;

public class _15_GroupsTest {

    @Test(priority = 1, groups = "Login")
    public void test1(){
        System.out.println("This is test1");
    }

    @Test(priority = 2, groups = "Purchase")
    public void test2(){
        System.out.println("This is test2");
    }

    @Test(priority = 3, groups = {"Login", "Purchase"})
    public void test3(){
        System.out.println("This is test3");
    }

    @Test(priority = 4, groups = "Purchase")
    public void test4(){
        System.out.println("This is test4");
    }

    @Test(priority = 5, groups = {"Functional", "Login"})
    public void test5(){
        System.out.println("This is test5");
    }
}
