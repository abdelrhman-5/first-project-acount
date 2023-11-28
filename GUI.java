
package javaapplication7;
import java.io.OutputStream;
import java.io.PrintStream;
import javaapplication7.CourseList.Course_Node;
import javaapplication7.StudentList.Std_Node;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    private Table tableObj;
    private TextArea consoleTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tableObj = new Table();

     
        StudentList stdList = new StudentList();
        CourseList courseList = new CourseList();

        Std_Node mohamed = stdList.addstudent(2201036, "Mohamed Ahmed");
        Std_Node zaky = stdList.addstudent(22014, "Zaky Yasser");
        Std_Node zain = stdList.addstudent(22314, "Zain Nagy");
 


        Course_Node mathZero = courseList.addCourse(10, "MathZero");
        Course_Node calculus = courseList.addCourse(11, "Calculus");
        Course_Node discrete = courseList.addCourse(13, "Discrete");
        Course_Node probability = courseList.addCourse(14, "Probability");
        
    Course_Node physics = courseList.addCourse(15, "Physics");
tableObj.addCourse(physics);
Std_Node john = stdList.addstudent(12345, "Atteya EL sayed");
tableObj.addStudent(john);
   tableObj.addStudentToCourse(john, physics);
        
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

    
        PrintStream consolePrintStream = createConsolePrintStream();
        System.setOut(consolePrintStream);
        System.setErr(consolePrintStream);

        Label studentIdLabel = new Label("Student ID:");
        TextField studentIdField = new TextField();
        Button displayCoursesButton = new Button("Display Courses");

        Label courseNameLabel = new Label("Course Name:");
        TextField courseNameField = new TextField();
        Button displayStudentsButton = new Button("Display Students");

        Label resultLabel = new Label();

        consoleTextArea = new TextArea(); 
        consoleTextArea.setEditable(false); 

        displayCoursesButton.setOnAction(e -> {
            int studentId = Integer.parseInt(studentIdField.getText());
            StringBuilder output = new StringBuilder();
            tableObj.displayCoursesByStudentId(studentId, output);
            resultLabel.setText(output.toString());
        });

        displayStudentsButton.setOnAction(e -> {
            String courseName = courseNameField.getText();
            StringBuilder output = new StringBuilder();
            tableObj.displayStudentsByCourseName(courseName, output);
            resultLabel.setText(output.toString());
        });

    
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(studentIdLabel, 0, 0);
        gridPane.add(studentIdField, 1, 0);
        gridPane.add(displayCoursesButton, 2, 0);
        gridPane.add(courseNameLabel, 0, 1);
        gridPane.add(courseNameField, 1, 1);
        gridPane.add(displayStudentsButton, 2, 1);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(gridPane, resultLabel, consoleTextArea);

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Course-Student GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private PrintStream createConsolePrintStream() {
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) {
                consoleTextArea.appendText(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) {
                String output = new String(b, off, len);
                consoleTextArea.appendText(output);
            }
        };

        return new PrintStream(outputStream, true);
    }
}