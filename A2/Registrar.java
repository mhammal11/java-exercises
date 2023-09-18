    // import arraylist and scanner packages
import java.util.ArrayList;
import java.util.Scanner;

public class Registrar {
    // create variables for the class Course
    ArrayList<Student> students;
    ArrayList<Course> courses;

    // initialize the variables
    public Registrar() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    /* function that checks if a student meets the requirements to enroll in
        a course that is if a student is enrolled in the prerequisite courses
        of the course he is trying to enroll in
    -- used in runInputCommands below
    -- takes in a student object and a course object */
    public boolean studentMeetsRequirements(Student studentToEnroll, Course courseToEnroll) {
        for (Course course2 : courseToEnroll.prerequisites) {
            boolean studentEnrolled = false;
            for (Section section : course2.getSections()) {
                if (section.enrolledStudents.contains(studentToEnroll)) {
                    studentEnrolled = true;
                    break;
                }
            }
            if (!studentEnrolled) {
                return false;
            }
        }
        return true;
    }

    /* function that checks if a student meets the requirements to unenroll from a course
        that if a student is enrolled in the prerequisite courses of the course he is
        trying to unenroll from
    -- used in runInputCommands below
    -- takes in a student object and a course object */
    public boolean studentCanUnenroll(Student studentToEnroll, Course courseToEnroll) {
        for (Course course1 : courseToEnroll.isPrereqFor) {
            boolean studentEnrolled = false;
            for (Section section : course1.getSections()) {
                if (section.enrolledStudents.contains(studentToEnroll)) {
                    studentEnrolled = true;
                    break;
                }
            }
            if (studentEnrolled) {
                return false;
            }
        }
        return true;
    }

    // function used in the Main class that runs the commands provided in the input
    public void runInputCommands() {
    // open a scanner to get input
        Scanner keyboard = new Scanner(System.in);
    // while loop to run through the input line by line
        while (keyboard.hasNext()) {
    // split each line into a list of strings
            String input = keyboard.nextLine();
            String[] listOfInputs = input.split(" ");

            if (input.startsWith("COURSE")) {
    // if the line starts with COURSE, add that course to the arraylist courses
                courses.add(new Course(listOfInputs[1]));

            } else if (input.startsWith("STUDENT")) {
    // if the line starts with STUDENT, add that student to the arraylist students
                students.add(new Student(listOfInputs[1], Integer.parseInt(listOfInputs[2])));

            } else if (input.startsWith("SECTION")) {
    /* if the line starts with SECTION, loop through all the courses added
       and add a section to the specified course */
                for (Course course : courses) {
                    course.addSection(new Section(listOfInputs[2],
                            Integer.parseInt(listOfInputs[3])));
                }
            } else if (input.startsWith("REQUIREMENT")) {
    /* if the line starts with REQUIREMENT, initialize two courses that will be filled with
       the course that has a requirement and the prerequisite for that course in the for loop
    -- add the prerequisite and the course with requirements to the respective arraylists
       created in the Course class */
                Course course1 = null;
                Course course2 = null;
                for (Course course : courses) {
                    if (listOfInputs[1].equals(course.getUniqueName())) {
                        course1 = course;
                        break;
                    }
                }
                for (Course course : courses) {
                    if (listOfInputs[2].equals(course.getUniqueName())) {
                        course2 = course;
                        break;
                    }
                }
                course1.prerequisites.add(course2);
                course2.isPrereqFor.add(course1);

            } else if (input.startsWith("ENROLL")) {
    /* if the line starts with ENROLL, initialize two a course and a student
       that will be filled with the student we wish to enroll and the course
       we wish to enroll them in using the for loop
    -- if the first boolean function we created at the top allows for a student
       to be enrolled then we can enroll the student and print the result
       from the TerminalPrinter class */
                Student studentToEnroll = null;
                Course courseToEnroll = null;
                for (Student student : students) {
                    if (student.getStudentID() == Integer.parseInt(listOfInputs[1])) {
                        studentToEnroll = student;
                        break;
                    }
                }
                for (Course course : courses) {
                    if (course.getUniqueName().equals(listOfInputs[2])) {
                        courseToEnroll = course;
                        break;
                    }
                }
                if (studentMeetsRequirements(studentToEnroll, courseToEnroll)) {
                    boolean enrollmentResult =
                            courseToEnroll.enrollStudent(studentToEnroll, listOfInputs[3]);
                    TerminalPrinter.printEnrollmentResult(enrollmentResult,
                            studentToEnroll.getName(),
                            courseToEnroll.getUniqueName(), listOfInputs[3]);
                } else {
                    TerminalPrinter.printEnrollmentResult(false,
                            studentToEnroll.getName(),
                            courseToEnroll.getUniqueName(), listOfInputs[3]);
                }

            } else if (input.startsWith("UNENROLL")) {
    /* if the line starts with UNENROLL, initialize two a course and a student
       that will be filled with the student we wish to unenroll and the course
       we wish to unenroll them from using the for loop
    -- if the second boolean function we created at the top allows for a student
       to be unenrolled then we can unenroll the student and print the result
       from the TerminalPrinter class */
                Student studentToEnroll = null;
                Course courseToEnroll = null;
                for (Student student : students) {
                    if (student.getStudentID() == Integer.parseInt(listOfInputs[1])) {
                        studentToEnroll = student;
                        break;
                    }
                }
                for (Course course : courses) {
                    if (course.getUniqueName().equals(listOfInputs[2])) {
                        courseToEnroll = course;
                        break;
                    }
                }
                if (studentCanUnenroll(studentToEnroll, courseToEnroll)) {
                    boolean enrollmentResult =
                            courseToEnroll.unenrollStudent(studentToEnroll, listOfInputs[3]);
                    TerminalPrinter.printUnenrollmentResult(enrollmentResult,
                            studentToEnroll.getName(),
                            courseToEnroll.getUniqueName(), listOfInputs[3]);
                } else {
                    TerminalPrinter.printUnenrollmentResult(false,
                            studentToEnroll.getName(),
                            courseToEnroll.getUniqueName(), listOfInputs[3]);
                }
            }
    // if the line starts with FINISH, it indicates the end of the input
            if (input.startsWith("FINISH")) {
                break;
            }
        }
    // close the scanner
        keyboard.close();
    }
}