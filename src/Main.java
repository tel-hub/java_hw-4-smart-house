import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static boolean validBinary(String str) {
        String regex = "^[0-1]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        return m.find();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("current time (hours: Integer) >");

        int hours = keyboard.nextInt();

        if (hours >= 0 && hours <= 23) {
            String[] days = {"mo", "tu", "we", "th", "fr", "sa", "su"};

            System.out.print("current day (" + String.join(",", days) + ") >");

            String day = keyboard.next();

            if (Arrays.asList(days).contains(day)) {

                System.out.print("alarm (1|0) >");

                String alarm = keyboard.next();

                if (validBinary(alarm)) {
                    boolean noAction = true;
                    boolean isWeekend = Arrays.asList(days).indexOf(day) > 5;

                    if (isWeekend) {
                        if (alarm.equals("0") && hours == 11) {
                            System.out.println("raise the curtains");
                            noAction = false;
                        }
                    } else {

                        if (alarm.equals("0") && hours == 8) {
                            System.out.println("raise the curtains");
                            noAction = false;
                        }

                        if (alarm.equals("1") && hours == 20) {
                            System.out.println("turn on the kettle");
                            noAction = false;
                        }
                    }

                    if (noAction) {
                        System.out.println("no actions on " + day + " at " + hours + " with alarm state " + alarm);
                    }
                } else {
                    System.out.println("incorrect alarm " + alarm);
                }

            } else {
                System.out.println("incorrect day " + day);
            }
        } else {
            System.out.println("incorrect time " + hours);
        }
    }
}
