# file-generator-0.0.1

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {

    public static void main(String[] args) {
        String x = "Tue Feb 07 15:40:12 IST 2022";
        String y = "2023-02-05";

        // Parse x to Date object with the given format
        SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date dateX;
        try {
            dateX = inputFormat.parse(x);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            return;
        }

        // Parse y to Date object with the given format
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateY;
        try {
            dateY = outputFormat.parse(y);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            return;
        }

        // Calculate the difference in days between the two dates
        long differenceInMilliseconds = dateY.getTime() - dateX.getTime();
        long differenceInDays = differenceInMilliseconds / (1000 * 60 * 60 * 24);

        // Check if the difference in days is less than 4
        if (differenceInDays < 4) {
            System.out.println("The difference in days between the dates is less than 4.");
        } else {
            System.out.println("The difference in days between the dates is 4 or more.");
        }
    }
}
