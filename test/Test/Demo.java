package Test;

import org.junit.*;
import static org.junit.Assert.*;


public class Demo {

    @Test
    public void DaysInMonth_UTDID01() {
        assertEquals(0, DateTime.DateTimeFunction.DaysInMonth(2000, -1));
    }

    @Test(expected = NullPointerException.class)
    public void DaysInMonth_UTDID03() {
        DateTime.DateTimeFunction.DaysInMonth(2000, null);
    }

    @Test
    public void CheckDate_UTCID05() {
        assertTrue(DateTime.DateTimeFunction.IsValidDate(2020, 2, 29));
    }

    @Test
    public void CheckDate_UTCID10() {
        assertTrue(DateTime.DateTimeFunction.IsValidDate(2000, 3, 29));
    }
}
