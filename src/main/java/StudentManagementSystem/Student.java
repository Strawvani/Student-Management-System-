package StudentManagementSystem;

import java.util.ArrayList;

public class Student extends Person{

    private int studentID;

    public Student (String name, int ID){
       super(name);
        this.studentID = ID;
    }

    public String getRole(){
        return getName() + " is a Student";
    }

    public int getStudentID(){
        return studentID;
    }
}
