package hw2.test;

import hw2.models.CountPeriod;
import log.Log;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestDateTimeAPI {


    Log log = new Log(TestDateTimeAPI.class.getName());

    private final LocalDate now = LocalDate.now();
    private final ZonedDateTime timeNow = ZonedDateTime.now();

    public TestDateTimeAPI printZonedDateTimeNow(){
        log.log(String.format("Print zoned datetime now: %s\n", timeNow));
        return this;
    }

    public TestDateTimeAPI printBirthday(){
        LocalDate birthdayTime = LocalDate.of(2002, Month.SEPTEMBER, 25);
        log.log(String.format("Print birthday: %s\n", birthdayTime));
        return this;
    }

    public TestDateTimeAPI printLocalTime(){
        LocalTime localTime = LocalTime.now();
        log.log(String.format("Print local time: %s\n", localTime));
        return this;
    }

    public TestDateTimeAPI printTimeSpan(){
        // USE OF FUNCTIONAL INTERFACES IN DATETIME API
        CountPeriod countPeriod = (LocalDate start, LocalDate end) -> Period.between(end, start);
        Period period = countPeriod.countPeriod(LocalDate.now(), now.plus(2, ChronoUnit.WEEKS));
        log.log(String.format("Print time span: %s\n", period));
        return this;
    }

    public TestDateTimeAPI printFormattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.log(String.format("Print formatted date: %s\n", now.format(formatter)));
        return this;
    }

    public TestDateTimeAPI printNumberOfDays(){
        Month feb = Month.FEBRUARY;
        log.log(String.format("Print number of days in the month: %s\n", feb.length(true)));
        return this;
    }

    public TestDateTimeAPI printFormattedZonedDateTime(){
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEE, dd-MM-yyyy HH:mm:ss zzz");
        log.log(String.format("Print formatted Zoned Date Time: %s\n", timeNow.format(formatter2)));
        return this;
    }
}
