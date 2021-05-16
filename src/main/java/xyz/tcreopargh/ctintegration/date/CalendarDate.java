package xyz.tcreopargh.ctintegration.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDate implements IDate {

    Calendar internal;

    public CalendarDate() {
        internal = Calendar.getInstance();
    }

    public CalendarDate(Calendar calendar) {
        internal = calendar;
    }

    public CalendarDate(Long timeInMillis) {
        internal = Calendar.getInstance();
        internal.setTimeInMillis(timeInMillis);
    }

    @Override
    public long getTimeInMillis() {
        return internal.getTimeInMillis();
    }

    @Override
    public void setTimeInMillis(long timeInMillis) {
        internal.setTimeInMillis(timeInMillis);
    }

    @Override
    public int getField(int field) {
        return internal.get(field);
    }

    @Override
    public void setField(int field, int value) {
        internal.set(field, value);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(internal.getTime());
    }

    @Override
    public String format(String formatString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        return simpleDateFormat.format(internal.getTime());
    }

    @Override
    public IDate add(IDate with) {
        long newTime = this.getTimeInMillis() + with.getTimeInMillis();
        Calendar ret = Calendar.getInstance();
        ret.setTimeInMillis(newTime);
        return new CalendarDate(ret);
    }

    @Override
    public int compare(IDate with) {
        return Long.compare(this.getTimeInMillis(), with.getTimeInMillis());
    }

    @Override
    public int getYear() {
        return internal.get(Calendar.YEAR);
    }

    @Override
    public void setYear(int value) {
        internal.set(Calendar.YEAR, value);
    }

    @Override
    public int getMonth() {
        return internal.get(Calendar.MONTH);
    }

    @Override
    public void setMonth(int value) {
        internal.set(Calendar.MONTH, value);
    }

    @Override
    public int getDay() {
        return internal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void setDay(int value) {
        internal.set(Calendar.DAY_OF_MONTH, value);
    }

    @Override
    public int getDayInWeek() {
        return internal.get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public void setDayInWeek(int value) {
        internal.set(Calendar.DAY_OF_WEEK, value);
    }

    @Override
    public int getHour() {
        return internal.get(Calendar.HOUR_OF_DAY);
    }

    @Override
    public void setHour(int value) {
        internal.set(Calendar.HOUR_OF_DAY, value);
    }

    @Override
    public int getMinute() {
        return internal.get(Calendar.MINUTE);
    }

    @Override
    public void setMinute(int value) {
        internal.set(Calendar.MINUTE, value);
    }

    @Override
    public int getSecond() {
        return internal.get(Calendar.SECOND);
    }

    @Override
    public void setSecond(int value) {
        internal.set(Calendar.SECOND, value);
    }

    @Override
    public int getMilliSecond() {
        return internal.get(Calendar.MILLISECOND);
    }

    @Override
    public void setMilliSecond(int value) {
        internal.set(Calendar.MILLISECOND, value);
    }

    @Override
    public Object getInternal() {
        return internal;
    }

    public void setInternal(Calendar internal) {
        this.internal = internal;
    }
}
