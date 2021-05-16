package xyz.tcreopargh.ctintegration.date;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.*;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "date.IDate")
public interface IDate {

    @ZenMethod
    static IDate getInstance() {
        return new CalendarDate();
    }

    @ZenGetter("timeInMillis")
    long getTimeInMillis();

    @ZenSetter("timeInMillis")
    void setTimeInMillis(long timeInMillis);

    @ZenMethod
    int getField(int field);

    @ZenMethod
    void setField(int field, int value);

    @ZenMethod
    String toString();

    @ZenMethod
    String format(String formatString);

    @ZenOperator(OperatorType.ADD)
    IDate add(IDate with);

    @ZenOperator(OperatorType.COMPARE)
    int compare(IDate with);

    @ZenGetter("year")
    int getYear();

    @ZenSetter("year")
    void setYear(int value);

    @ZenGetter("month")
    int getMonth();

    @ZenSetter("month")
    void setMonth(int value);

    @ZenGetter("day")
    int getDay();

    @ZenSetter("day")
    void setDay(int value);

    @ZenGetter("dayInWeek")
    int getDayInWeek();

    @ZenSetter("dayInWeek")
    void setDayInWeek(int value);

    @ZenGetter("hour")
    int getHour();

    @ZenSetter("hour")
    void setHour(int value);

    @ZenGetter("minute")
    int getMinute();

    @ZenSetter("minute")
    void setMinute(int value);

    @ZenGetter("second")
    int getSecond();

    @ZenSetter("second")
    void setSecond(int value);

    @ZenGetter("milliSecond")
    int getMilliSecond();

    @ZenSetter("milliSecond")
    void setMilliSecond(int value);

    Object getInternal();

}
