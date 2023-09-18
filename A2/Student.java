public class Student {
    // create variables for the class Course
    private int studentID;
    private String name;

    // initialize the variables
    Student(String name, int studentID) {
        this.studentID = studentID;
        this.name = name;
    }

    // getter function to access the private int studentID
    public int getStudentID() {
        return studentID;
    }

    // getter function to access the private String name
    public String getName() {
        return name;
    }
}
