package StudentManagementSystem;

public class Enrollment {
private int studentID;
private String courseID;

    public Enrollment(int studentID,String courseID){
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public int getStudentID(){
        return studentID;
    }

    public  String getCourseID(){
        return courseID;
    }


}
