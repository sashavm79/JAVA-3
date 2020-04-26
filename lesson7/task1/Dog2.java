package task1;

public class Dog2 {
    @BeforeSuite
    public void begin(){
        String s = "Test Dog2";
        System.out.println(s);
    }

    @Test(priority = 1)
    public int multi(){
        int a = 4;
        int b = 2;
        int c = a * b;
        return c;
    }

    @Test(priority = 0)
    public int div(){
        int a = 6;
        int b = 3;
        int c = a / b;
        return c;
    }

    @AfterSuite
    public void end(){
        String s = "Finish test Dog2";
        System.out.println(s);
    }
}