/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author Abdul
 */
public class CourseList {
        
    Course_Node Course_header;
    
    public class Course_Node{
 int Course_id;
 String Course_name;
 Course_Node Next_Cour;
 Cell Next_Cell;

        public Course_Node(int Course_id, String Course_name) {
            this.Course_id = Course_id;
            this.Course_name = Course_name;
        }

        public int getCourse_id() {
            return Course_id;
        }

        
        public Cell getCourse_header(){
        
        return this.Next_Cell;}
        public void setCourse_id(int Course_id) {
            this.Course_id = Course_id;
        }

        public String getCourse_name() {
            return Course_name;
        }

        public void setCourse_name(String Course_name) {
            this.Course_name = Course_name;
        }

        public Course_Node getNext_Cour() {
            return Next_Cour;
        }

        public void setNext_Cour(Course_Node Next_Cour) {
            this.Next_Cour = Next_Cour;
        }

    
        public Cell getNext_Cell() {
            return Next_Cell;
        }

        public void setNext_Cell(Cell Next_Cell) {
            this.Next_Cell = Next_Cell;
        }}
 
public Course_Node addCourse(int Course_id, String Course_name) {
    Course_Node Course = new Course_Node(Course_id, Course_name);

    if (Course_header == null) {
        Course_header = Course;
    } else {
        Course_Node tmp = Course_header;
        while (tmp.Next_Cour != null) {
            tmp = tmp.Next_Cour;
        }
        tmp.Next_Cour = Course;
    }

    return Course; 
}
 
    }
    

