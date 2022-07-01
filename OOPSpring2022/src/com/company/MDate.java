package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class MDate {
    private String dayName;
    private int day;
    private String month;
    private String year;
    private String timeZone="GMT+3:00";
    private String hour="00";
    private String minute="00";
    private String sec="00";

    public MDate(String date){
        getConvertedDay(date);
    }

    private void getConvertedDay(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        dayName= date.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        day=date.getDayOfMonth();
        month=date.getMonth().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        year= String.valueOf(date.getYear());
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    @Override
    public String toString() {
        return ""+ dayName+
                " "+ month +
                " "+hour+":"+minute+":"+sec+
                " " + timeZone +
                " " + year;
    }
}
