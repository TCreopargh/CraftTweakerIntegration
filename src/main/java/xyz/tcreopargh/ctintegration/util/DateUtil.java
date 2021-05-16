package xyz.tcreopargh.ctintegration.util;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;
import xyz.tcreopargh.ctintegration.date.IDate;
import xyz.tcreopargh.ctintegration.date.CalendarDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.DateUtil")
public class DateUtil {

    @ZenMethod
    public static IDate now() {
        return new CalendarDate();
    }

    public static IDate fromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new CalendarDate(cal);
    }

    @ZenMethod
    public static IDate fromTimeInMillis(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return new CalendarDate(cal);
    }

    @ZenMethod
    public static IDate parse(String format, String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(dateString);
            return fromDate(date);
        } catch (ParseException e) {
            CraftTweakerAPI.logInfo("Wrong date format: cannot format " + dateString + " with " + format);
            return null;
        }
    }

    @ZenMethod
    public static int ERA() {
        return Calendar.ERA;
    }

    @ZenMethod
    public static int YEAR() {
        return Calendar.YEAR;
    }

    @ZenMethod
    public static int MONTH() {
        return Calendar.MONTH;
    }

    @ZenMethod
    public static int WEEK_OF_YEAR() {
        return Calendar.WEEK_OF_YEAR;
    }

    @ZenMethod
    public static int WEEK_OF_MONTH() {
        return Calendar.WEEK_OF_MONTH;
    }

    @ZenMethod
    public static int DATE() {
        return Calendar.DATE;
    }

    @ZenMethod
    public static int DAY_OF_MONTH() {
        return Calendar.DAY_OF_MONTH;
    }

    @ZenMethod
    public static int DAY_OF_YEAR() {
        return Calendar.DAY_OF_YEAR;
    }

    @ZenMethod
    public static int DAY_OF_WEEK() {
        return Calendar.DAY_OF_WEEK;
    }

    @ZenMethod
    public static int DAY_OF_WEEK_IN_MONTH() {
        return Calendar.DAY_OF_WEEK_IN_MONTH;
    }

    @ZenMethod
    public static int AM_PM() {
        return Calendar.AM_PM;
    }

    @ZenMethod
    public static int HOUR() {
        return Calendar.HOUR;
    }

    @ZenMethod
    public static int HOUR_OF_DAY() {
        return Calendar.HOUR_OF_DAY;
    }

    @ZenMethod
    public static int MINUTE() {
        return Calendar.MINUTE;
    }

    @ZenMethod
    public static int SECOND() {
        return Calendar.SECOND;
    }

    @ZenMethod
    public static int MILLISECOND() {
        return Calendar.MILLISECOND;
    }

    @ZenMethod
    public static int ZONE_OFFSET() {
        return Calendar.ZONE_OFFSET;
    }

    @ZenMethod
    public static int DST_OFFSET() {
        return Calendar.DST_OFFSET;
    }

    @ZenMethod
    public static int FIELD_COUNT() {
        return Calendar.FIELD_COUNT;
    }

    @ZenMethod
    public static int SUNDAY() {
        return Calendar.SUNDAY;
    }

    @ZenMethod
    public static int MONDAY() {
        return Calendar.MONDAY;
    }

    @ZenMethod
    public static int TUESDAY() {
        return Calendar.TUESDAY;
    }

    @ZenMethod
    public static int WEDNESDAY() {
        return Calendar.WEDNESDAY;
    }

    @ZenMethod
    public static int THURSDAY() {
        return Calendar.THURSDAY;
    }

    @ZenMethod
    public static int FRIDAY() {
        return Calendar.FRIDAY;
    }

    @ZenMethod
    public static int SATURDAY() {
        return Calendar.SATURDAY;
    }

    @ZenMethod
    public static int JANUARY() {
        return Calendar.JANUARY;
    }

    @ZenMethod
    public static int FEBRUARY() {
        return Calendar.FEBRUARY;
    }

    @ZenMethod
    public static int MARCH() {
        return Calendar.MARCH;
    }

    @ZenMethod
    public static int APRIL() {
        return Calendar.APRIL;
    }

    @ZenMethod
    public static int MAY() {
        return Calendar.MAY;
    }

    @ZenMethod
    public static int JUNE() {
        return Calendar.JUNE;
    }

    @ZenMethod
    public static int JULY() {
        return Calendar.JULY;
    }

    @ZenMethod
    public static int AUGUST() {
        return Calendar.AUGUST;
    }

    @ZenMethod
    public static int SEPTEMBER() {
        return Calendar.SEPTEMBER;
    }

    @ZenMethod
    public static int OCTOBER() {
        return Calendar.OCTOBER;
    }

    @ZenMethod
    public static int NOVEMBER() {
        return Calendar.NOVEMBER;
    }

    @ZenMethod
    public static int DECEMBER() {
        return Calendar.DECEMBER;
    }

    @ZenMethod
    public static int UNDECIMBER() {
        return Calendar.UNDECIMBER;
    }

    @ZenMethod
    public static int AM() {
        return Calendar.AM;
    }

    @ZenMethod
    public static int PM() {
        return Calendar.PM;
    }

}
