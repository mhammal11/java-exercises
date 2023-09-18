    // import arraylist package
import java.util.ArrayList;

public class Course {
    /* create variables for the class Course
    -- uniqueName for the name of the course
       create arraylists that will be used to store data
    -- prerequisites will store course prereqs from the REQUIREMENT line in input
    -- isPrereqFor will store courses that have prereqs from REQUIREMENT
    -- both these arraylists are public so they can be accessed from the Registrar class */
    private String uniqueName;
    private ArrayList<Section> sections;
    public ArrayList<Course> prerequisites;
    public ArrayList<Course> isPrereqFor;

    // initialize all the private and public variables
    Course(String uniqueName) {
        this.uniqueName = uniqueName;
        sections = new ArrayList<>();
        prerequisites = new ArrayList<>();
        isPrereqFor = new ArrayList<>();
    }

    // addSection function adds sections from input to a specific course
    boolean addSection(Section section) {
        if (sections.contains(section)) {
            return false;
        } else {
            sections.add(section);
        return true;
        }
    }
    
    /* enrollStudent function provides a boolean value and checks if a
       student can or cannot be enrolled in a specific course
       and takes a student object and the section name */
    boolean enrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        if (sectionIndex == -1) {
            return false;
        } else {
            return sections.get(sectionIndex).enrollStudent(student);
        }
    }

    /* enrollStudent function provides a boolean value and checks if a
       student can or cannot be enrolled in a specific course
       and takes a student object and the section name */
    boolean unenrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        if (sectionIndex == -1) {
            return false;
        } else {
            return sections.get(sectionIndex).unenrollStudent(student);
        }
    }

    /* function that returns section index used to check if a student can
       or cannot be enrolled or unenrolled in a specific course */
    private int getSectionIndex(String sectionName) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equals(sectionName)) {
                return i;
            }
        }
        return -1;
    }

    // getter function to access the private arraylist sections
    public ArrayList<Section> getSections() {
        return sections;
    }

    // getter function to access the private String uniqueName
    public String getUniqueName() {
        return uniqueName;
    }
}