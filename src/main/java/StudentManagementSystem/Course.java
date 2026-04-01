package StudentManagementSystem;

import java.util.ArrayList;

public class Course {

    private String name,code;
    private int maxCap;

    ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course (String courseName, String courseCode, int maxCap){
        this.name = courseName;
        this.code = courseCode;
        this.maxCap = maxCap;
    }

    public ArrayList<Student> getEnrolledStudents(){
        return enrolledStudents;
    }

    public boolean isFull(){
        return enrolledStudents.size() >= maxCap;
    }

    public String getCourseName(){
        return name;
    }

    public String getCode(){
        return code;
    }

    public int getMaxCap(){
        return maxCap;
    }
}
