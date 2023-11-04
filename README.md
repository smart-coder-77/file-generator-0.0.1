import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Given date (in this example, the current date is used)
        Date givenDate = new Date();

        // Create a calendar instance and set it to the given date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(givenDate);

        // Move to the first day of the current month
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Move back one day to get to the last day of the previous month
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        // Get the last date of the previous month as a Date object
        Date lastDayOfPreviousMonth = calendar.getTime();

        System.out.println("Last date of the previous month: " + lastDayOfPreviousMonth);
    }
}
