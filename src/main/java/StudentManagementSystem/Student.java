package StudentManagementSystem;

import java.util.ArrayList;

public class Student extends Person{

    private int studentID;

    ArrayList<Course> enrolledCourses = new ArrayList<>();

    public Student (String name, int ID){
       super(name);
        this.studentID = ID;
    }

    public void enroll(Course course){
        enrolledCourses.add(course);
    }

    public String getRole(){
        return getName() + " is a Student";
    }

    public int getStudentID(){
        return studentID;
    }
}
