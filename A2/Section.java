    // import arraylist package
import java.util.ArrayList;

public class Section {
    // create variables for the class Section
    private String sectionName;
    private int maxEnrolment;
    public ArrayList<Student> enrolledStudents;

    // initialize the variables
    Section(String sectionName, int maxEnrolment) {
        enrolledStudents = new ArrayList<>();
        this.maxEnrolment = maxEnrolment;
        this.sectionName = sectionName;
    }

    /* enrollStudent function provides a boolean value and checks if a
       student can or cannot be enrolled in a specific course
       based on whether a section is full or not */
    boolean enrollStudent(Student student) {
        if (enrolledStudents.size() >= maxEnrolment) {
            return false;
        } else {
            enrolledStudents.add(student);
            return true;
        }
    }

    /* enrollStudent function provides a boolean value and checks if a
       student can or cannot be enrolled in a specific course
       if the student is already enrolled in that course */
    public boolean unenrollStudent(Student student) {
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getStudentID() == student.getStudentID()) {
                enrolledStudents.remove(i);
                return true;
            }
        }
        return false;
    }

    // getter function to access the private String sectionName
    public String getSectionName() {
        return sectionName;
    }
}
