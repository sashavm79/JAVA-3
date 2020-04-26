package task1;

import java.lang.annotation.Annotation;

public class Dog1 {
    @BeforeSuite
    public void begin(){
        String s = "Test Dog1";
        System.out.println(s);
    }

    @Test(priority = 1)
    public int summ(){
        int a = 2;
        int b = 2;
        int c = a + b;
        return c;
    }

    @Test(priority = 0)
    public int sub(){
        int a = 5;
        int b = 1-3;
        int c = a - b;
        return c;
    }

    @AfterSuite
    public void end(){
        String s = "Finish test Dog1";
        System.out.println(s);
    }
}