package task1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
    static void start(Class c) throws RuntimeException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException{

        Object obj = Class.forName(c.getName()).newInstance();

        Method[] method = c.getMethods();
        int count = 0;
        for (Method m : method) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                count++;
                if (count == 2) throw new RuntimeException("BeforeSuite используется больше одного раза");
                m.invoke(obj);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < method.length; j++) {
                if (method[j].isAnnotationPresent(Test.class)) {
                    int a = method[j].getAnnotation(Test.class).priority();
                    if (a == i) {
                        System.out.println(method[j].invoke(obj));
                    }
                }
            }
        }
        for (Method m : method) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                count++;
                if (count == 3) throw new RuntimeException("AfterSuite используется больше одного раза");
                m.invoke(obj);
            }
        }
    }

    public static void main(String[] args) {
        try {
            start(Dog1.class);
            start(Dog2.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}