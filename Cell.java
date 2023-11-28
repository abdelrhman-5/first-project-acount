/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author Abdul
 */


public class Cell {
  
    int Course_id;
    int Student_id;
    Cell Next_right;
    Cell Next_down;

    public Cell(int Course_id, int Student_id) {
        this.Course_id = Course_id;
        this.Student_id = Student_id;
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(int Course_id) {
        this.Course_id = Course_id;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }

    public Cell getNext_right() {
        return Next_right;
    }

    public void setNext_right(Cell Next_right) {
        this.Next_right = Next_right;
    }

    public Cell getNext_down() {
        return Next_down;
    }

    public void setNext_down(Cell Next_down) {
        this.Next_down = Next_down;
    }
    
    
            
}
