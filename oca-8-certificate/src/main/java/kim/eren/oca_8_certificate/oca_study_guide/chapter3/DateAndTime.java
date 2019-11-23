package kim.eren.oca_8_certificate.oca_study_guide.chapter3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;

public class DateAndTime {
    /**
     *  <b>LocalDate<b> Contains just a date—no time and no time zone. A good example of
        LocalDate is your birthday this year. It is your birthday for a full day regardless
        of what time it is.

         <b>LocalTime<b> Contains just a time—no date and no time zone. A good example of
        LocalTime is midnight. It is midnight at the same time every day.

        <b>LocalDateTime<b> Contains both a date and time but no time zone. A good example of
        LocalDateTime is “the stroke of midnight on New Year’s.” Midnight on January 2 isn’t
        nearly as special, and clearly an hour after midnight isn’t as special either.
     */
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019,1,20);
        Period period = Period.ofMonths(1);
        LocalDate plussedDate = date.plusDays(-1).plus(period);
        System.out.println(plussedDate);
        
    }
}