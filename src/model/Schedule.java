package model;

import java.sql.Time;

public class Schedule {
    private String dayOfWeek;
    private String time;
    private String room;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }

    public boolean conflictsWith(Schedule other){
        String dayOfWeek1 = other.dayOfWeek;
        String time1 = other.time;


        return false;
    }
}
