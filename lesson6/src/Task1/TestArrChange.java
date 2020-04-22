package Task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrChange {
    ArrChange arrChange;

    @Before
    public void init() {
        System.out.println("Тест массива");
        arrChange = new ArrChange();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new Integer[]{1, 7}, arrChange.arrchange(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        Assert.assertArrayEquals(null, arrChange.arrchange(new int[]{3, 5, 3, 3, 2, 7, 8}));
    }

}
