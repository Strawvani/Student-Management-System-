package StudentManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        EnrollmentService service = new EnrollmentService();
        Scanner scan = new Scanner(System.in);

    while (true){

        int choice;

        System.out.println("\n===Student Management System===");
        System.out.println("1.Add Student");
        System.out.println("2.Add Course");
        System.out.println("3.Enroll Student");
        System.out.println("4.List All Students");
        System.out.println("5.List All Courses");
        System.out.println("6.View Enrollment in Courses");
        System.out.println("7.Exit");

        try {
            System.out.println("Choose an Option");
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please Input an Integer, Try Again!");
           continue;
        }


        switch (choice) {
            case 1:
                try {
                    System.out.println("Student Name: ");
                    String studentName = scan.nextLine();
                    System.out.println("Student ID: ");
                    int studentID = Integer.parseInt(scan.nextLine());
                    if (service.StudentExist(studentID)){
                        System.out.println("Student ID: " + studentID + " already exist");
                    } else {
                        service.addStudent(new Student(studentName, studentID));
                    }
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Student ID must be an Integer");
                    break;
                }

            case 2:
                System.out.println("Course Name: ");
                String courseName = scan.nextLine();
                System.out.println("Course Code: ");
                String courseCode = scan.nextLine();
                try{
                    System.out.println("Course Max Student Capacity: ");
                    int maxCapacity = Integer.parseInt(scan.nextLine());
                    if (service.CourseExist(courseCode)){
                        System.out.println("Course Code: " + courseCode + " already exist");
                    } else {
                        System.out.println("Course Successfully Added: " + courseCode);
                        service.addCourse(new Course(courseName,courseCode,maxCapacity));
                    }
                } catch (NumberFormatException e){
                    System.out.println("Course Max Capacity must be an Integer");
                }
                break;


            case 3:
                try {
                    System.out.println("Student ID: ");
                    int studentID = Integer.parseInt(scan.nextLine());
                    System.out.println("Course Code: ");
                    courseCode = scan.nextLine();
                    service.enrollStudent(studentID,courseCode);
                } catch (NumberFormatException e){
                    System.out.println("Student ID must be an Integer");
                    break;
                } catch (EnrollmentException e){
                    System.out.println("Error " + e.getMessage());
                }
                break;

            case 4:
                service.listAllStudents();
                break;

            case 5:
                service.listAllCourses();
                break;
            case 6:
                System.out.println("===Viewing Course Enrollment===");
                System.out.println("Enter What Course Code to View: ");
                String viewcourseCode = scan.nextLine();
                service.viewCourseEnrollments(viewcourseCode);
                break;
            case 7:
                System.out.println("Thank you for using the Student Management System");
                return;

            default:
                System.out.println("Please Input a Valid Integer from the Choices");
                break;
        }
    }

    }

}
