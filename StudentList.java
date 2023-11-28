/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author Abdul
 */


public class StudentList {
    private Std_Node header_stud;

    public class Std_Node {
        private String Std_name;
        private int Std_id;
        private Std_Node Next_Std;
        private Cell Next_cell;

        public Std_Node(String Std_name, int Std_id) {
            this.Std_name = Std_name;
            this.Std_id = Std_id;
        }

        public String getStd_name() {
            return Std_name;
        }

        public void setStd_name(String Std_name) {
            this.Std_name = Std_name;
        }

        public int getStd_id() {
            return Std_id;
        }

        public void setStd_id(int Std_id) {
            this.Std_id = Std_id;
        }

        public Std_Node getNext_Std() {
            return Next_Std;
        }

        public void setNext_Std(Std_Node Next_Std) {
            this.Next_Std = Next_Std;
        }

        public Cell getNext_cell() {
            return Next_cell;
        }

        public void setNext_cell(Cell Next_cell) {
            this.Next_cell = Next_cell;
        }
    }

    public Std_Node addstudent(int Std_id, String Std_name) {
        Std_Node Student = new Std_Node(Std_name, Std_id);
        if (header_stud == null) {
            header_stud = Student;
            header_stud.Next_Std = null;
        } else {
            Std_Node tmp = header_stud;
            while (tmp.Next_Std != null) {
                tmp = tmp.Next_Std;
            }
            tmp.Next_Std = Student; // Add the new student to the end of the linked list
        }

        return Student; // Return the newly added student
    }
}