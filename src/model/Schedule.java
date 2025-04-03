package model;

public class Schedule {
    private String dayOfWeek;
    private String time;
    private String room;

    public boolean conflictsWith(Schedule other) {
        String dayOfWeek1 = other.dayOfWeek;
        String time1 = other.time;
        if (dayOfWeek1.equals(dayOfWeek) && time1.equals(time)) {
            return true;
        }
        return false;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "| День " + dayOfWeek + "| Время " + time + "| Аудитория " + room;
    }
}
