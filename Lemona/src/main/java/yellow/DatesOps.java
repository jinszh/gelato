package yellow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatesOps {
    //Find Days in week
    public void findDaysInWeek(int month, int day, int year) {
        //Java 7
        Calendar c = new GregorianCalendar();
        c.set(year, month - 1, day);
        int wd = c.get(Calendar.DAY_OF_WEEK);
        String [] weekdays = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        System.out.println(weekdays[wd - 1]);

        //Java 8 version
        LocalDate dt = LocalDate.of(year, month, day);
        System.out.print(dt.getDayOfWeek());
    }
}
