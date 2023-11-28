/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

import javaapplication7.CourseList.Course_Node;
import javaapplication7.StudentList.Std_Node;

/**
 *
 * @author Abdul
 */
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Std_Node> students;
    private List<Course_Node> courses;

    public Table() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudentToCourse(Std_Node studentObj, Course_Node courseObj) {
        int stdId = studentObj.getStd_id();
        int courseId = courseObj.getCourse_id();

        Cell cell = new Cell(courseId, stdId);

        if (courseObj.getNext_Cell() == null) {
            courseObj.setNext_Cell(cell);
        } else {
            Cell cellTmp = courseObj.getNext_Cell();
            while (cellTmp.getNext_right() != null) {
                cellTmp = cellTmp.getNext_right();
            }
            cellTmp.setNext_right(cell);
        }

        if (studentObj.getNext_cell() == null) {
            studentObj.setNext_cell(cell);
        } else {
            Cell cellTmp = studentObj.getNext_cell();
            while (cellTmp.getNext_down() != null) {
                cellTmp = cellTmp.getNext_down();
            }
            cellTmp.setNext_down(cell);
        }
    }

    public void displayCoursesByStudentId(int studentId, StringBuilder output) {
        boolean found = false;
        for (Std_Node std : students) {
            if (std.getStd_id() == studentId) {
                found = true;
                System.out.println("Courses that this student is enrolled in: " );
                Cell cellDisplay = std.getNext_cell();
                while (cellDisplay != null) {
                    int courseId = cellDisplay.getCourse_id();
                    for (Course_Node course : courses) {
                        if (course.getCourse_id() == courseId) {
                            System.out.println(course.getCourse_name());
                            break;
                        }
                    }
                    cellDisplay = cellDisplay.getNext_down();
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void displayStudentsByCourseName(String courseName, StringBuilder output) {
        boolean found = false;
        for (Course_Node course : courses) {
            if (course.getCourse_name().equalsIgnoreCase(courseName)) {
                found = true;
                System.out.println("Students enrolled in the course '" + courseName + "':");
                Cell cellDisplay = course.getNext_Cell();
                while (cellDisplay != null) {
                    int stdId = cellDisplay.getStudent_id();
                    for (Std_Node std : students) {
                        if (std.getStd_id() == stdId) {
                            System.out.println(std.getStd_name());
                            break;  
                        }
                    }
                    cellDisplay = cellDisplay.getNext_right();
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Course not found.");
        }
    }

    public void addStudent(Std_Node student) {
        students.add(student);
    }

    public void addCourse(Course_Node course) {
        courses.add(course);
    }

    public static void main(String[] args) {
        Table tableObj = new Table();

        StudentList stdList = new StudentList();
        CourseList courseList = new CourseList();

        Std_Node mohamed = stdList.addstudent(2201036, "Mohamed Ahmed");
        Std_Node zaky = stdList.addstudent(22014, "Zaky Yasser");
        Std_Node zain = stdList.addstudent(22314, "Zain Nagy");
          


        Course_Node mathZero = courseList.addCourse(10, "MathZero");
        Course_Node calculus = courseList.addCourse(11, "Calculus");
        Course_Node discrete = courseList.addCourse(13, "Discrete");
        Course_Node probability = courseList.addCourse(14, "Probability");
         



        tableObj.addStudent(mohamed);
        tableObj.addStudent(zaky);
        tableObj.addStudent(zain);

        tableObj.addCourse(mathZero);
        tableObj.addCourse(calculus);
        tableObj.addCourse(discrete);
        tableObj.addCourse(probability);

        tableObj.addStudentToCourse(zain, probability);
        tableObj.addStudentToCourse(zaky, discrete);
        tableObj.addStudentToCourse(mohamed, discrete);
        tableObj.addStudentToCourse(zaky, calculus);
   
    


    }
}