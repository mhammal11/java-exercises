import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Class to write dates in the desired format
class Utils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    // Convert the date into desired format
    static Date convertDate(String input) throws ParseException {
        return formatter.parse(input);
    }
    // Format date based on Year/Month/Day
    static String formattedDate(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
