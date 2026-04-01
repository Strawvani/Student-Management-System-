package StudentManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class EnrollmentService {

    HashMap<String,Course> courseRegistry = new HashMap<>();
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
        System.out.println(student.getName() + " is Added Successfully.");
    }

    public void addCourse(Course course){
        courseRegistry.put(course.getCode(), course);
        System.out.println(course.getCourseName() + " is Added Successfully.");
    }


    public void listAllStudents (){
        if (students.isEmpty()){
            System.out.println("Theres currently no student in the list");
        } else {
            Student student = null;
            System.out.println("===Student List===");
            for (int i = 0; i < students.size(); i++) {
                student = students.get(i);
                System.out.println(((i + 1) + "." + student.getName() + " StudentID: " + student.getStudentID()));
            }
        }
    }

    public void listAllCourses (){
        if (courseRegistry.isEmpty()){
            System.out.println("Theres currently no Courses in the list");
        } else {
            int i = 0;
            System.out.println("===Course List===");
            for (HashMap.Entry<String,Course> entry : courseRegistry.entrySet()){
                String key = entry.getKey();
                Course value = entry.getValue();
                System.out.println((i+1) + ".Course Code# " + key + " || " + value.getCourseName() + " || Capacity:" + courseRegistry.get(key).getEnrolledStudents().size() + "/" + courseRegistry.get(key).getMaxCap());
                i++;
            }
        }
    }

    public void viewCourseEnrollments (String courseCode){
        Course course = courseRegistry.get(courseCode);

        if (course == null){
            System.out.println("Course not found.");
            return;
        }

        if (course.getEnrolledStudents().isEmpty()){
            System.out.println("There's no one currently enrolled in " + course.getCourseName());
        } else {
            System.out.println("===Enrolled Students in " + course.getCourseName() + "===");
            for (int i = 0; i < course.getEnrolledStudents().size(); i++){
                Student student = course.getEnrolledStudents().get(i);
                System.out.println((i+1) + ". " + student.getName() + " || Student ID: " + student.getStudentID());
            }
        }


    }

    public boolean StudentExist(int id){
        for (Student student : students){
            if (student.getStudentID() == id) return true;
            }
        return false;
        }

    public boolean CourseExist(String code){
        return courseRegistry.containsKey(code);
    }
}

