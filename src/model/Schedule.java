package model;

public class Schedule {
    private String dayOfWeek;
    private String time;
    private String room;


   public boolean hasSpace() {
        return false;
    }

   public void enrollStudent(Student student) {

    }
    public boolean conflictsWith(Schedule other){
        return false;
    }
}
