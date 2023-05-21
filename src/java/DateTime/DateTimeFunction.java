/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTime;

/**
 *
 * @author Thuan
 */
public class DateTimeFunction {
    static public int DaysInMonth(int Year, int Month) {
        if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12) {
            return 31;
        }
        if (Month == 4 || Month == 6 || Month == 9 || Month == 11) {
            return 30;
        }
        if (Year % 400 == 0) {
            return 29;
        }
        if (Year % 100 == 0) {
            return 28;
        }
        if (Year % 4 == 0) {
            return 29;
        }
        return 28;
    }

    static public boolean IsValidDate(int Year, int Month, int Day) {
        return Day <= DaysInMonth(Year, Month);
    }
}
