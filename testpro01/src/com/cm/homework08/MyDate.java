package com.cm.homework08;

import java.util.Objects;

public class MyDate {
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;

        MyDate myDate = (MyDate) obj;

        return year.equals(myDate.getYear()) && month.equals(myDate.getMonth()) && day.equals(myDate.getDay()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year,month,day);
    }
}
