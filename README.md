import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Given date (in this example, the current date is used)
        Date givenDate = new Date();

        // Create a calendar instance and set it to the given date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(givenDate);

        // Find the last Saturday from the given date
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }

        // Get the last Saturday as a Date object
        Date lastSaturday = calendar.getTime();

        System.out.println("Last Saturday from the given date: " + lastSaturday);
    }
}
