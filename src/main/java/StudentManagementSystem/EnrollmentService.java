package StudentManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentService {

    HashMap<String,Course> courseRegistry = new HashMap<>();
    ArrayList<Enrollment> enrollmentList = new ArrayList();
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
        System.out.println(student.getName() + " is Added Successfully.");
    }

    public void addCourse(Course course){
        courseRegistry.put(course.getCode(), course);
        System.out.println(course.getCourseName() + " is Added Successfully.");
    }

    public boolean isCourseFull (String courseID){
        Course course = courseRegistry.get(courseID);
        int count = 0;
        for (Enrollment e : enrollmentList){
            if (e.getCourseID().equals(courseID)) count++;
        }
        return count >= course.getMaxCap();
    }

    public void enrollStudent(int studentID, String courseID) throws EnrollmentException{
        Student foundStudent = null;

        for (Student s : students){
            if (s.getStudentID() == studentID){
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null){
           throw new EnrollmentException("Student ID: " + studentID + " doesn't exist.");
        }

        Course course = courseRegistry.get(courseID);
        if (course == null){
            throw new EnrollmentException("Course ID: " + courseID + " doesn't exist.");
        }

        if (isCourseFull(courseID)){
            throw new EnrollmentException("Course " + courseID + " is full.");
        }

        for (Enrollment e : enrollmentList){
            if (e.getStudentID() == studentID && e.getCourseID().equals(courseID)){
                throw new EnrollmentException("Student ID: " + studentID + " is already enrolled in " + courseID);
            }
        }

        enrollmentList.add(new Enrollment(studentID,courseID));
        System.out.println("Student ID: " + studentID + " is successfully enrolled in " + courseID);

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
            System.out.println("===Course List===");
            int i  = 0;
            for (HashMap.Entry<String,Course> entry : courseRegistry.entrySet()){
            Course value = entry.getValue();
                System.out.println((i+1) + ". " + value.getCourseName() + " | " + value.getCode() + " | Max Capacity: " + value.getMaxCap());
            }
        }
    }

    public void viewCourseEnrollments (String courseCode){
        Course course = courseRegistry.get(courseCode);
        if (course == null){
            System.out.println("Course: " + courseCode + " not found.");
            return;
        }

        System.out.println("=== Students enrolled in " + course.getCourseName() + " ===");
        boolean hasStudents = false;
        int i = 0;
        for (Enrollment e: enrollmentList){
            if (e.getCourseID().equals(courseCode)){
                for (Student s : students){
                    if (s.getStudentID() == e.getStudentID()){
                        System.out.println((i+1) +". " + s.getName() + " | " + s.getStudentID());
                        i++;
                    }
                }
                hasStudents = true;
            }
        }
        if (!hasStudents){
            System.out.println("No Students found.");
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

