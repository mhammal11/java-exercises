public class TerminalPrinter {

    /* function that prints the enrollment result from the Registrar class
       and takes a studentName, a courseName, and a sectionName from the input */
    static void printEnrollmentResult(boolean wasSuccessful,
                                      String studentName,
                                      String courseName,
                                      String sectionName) {
        if (wasSuccessful) {
            System.out.println(studentName + " WAS ENROLLED IN "
                    + courseName + " SECTION " + sectionName);
        } else {
            System.out.println(studentName + " WAS NOT ENROLLED IN " + courseName
                    + " SECTION " + sectionName);
        }
    }

    /* function that prints the unenrollment result from the Registrar class
       and takes a studentName, a courseName, and a sectionName from the input */
    static void printUnenrollmentResult(boolean wasSuccessful,
                                      String studentName,
                                      String courseName,
                                      String sectionName) {
        if (wasSuccessful) {
            System.out.println(studentName + " WAS UNENROLLED FROM "
                    + courseName + " SECTION " + sectionName);
        } else {
            System.out.println(studentName + " WAS NOT UNENROLLED FROM "
                    + courseName + " SECTION " + sectionName);
        }
    }
}
