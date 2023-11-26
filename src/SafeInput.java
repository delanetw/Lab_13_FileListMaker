import java.util.Scanner;

public class SafeInput
{
    /**
     * returns a String input by the user that must be at least one character
     *
     * @param pipe   the scanner to use or get input
     * @param prompt the msg for the user telling them what to input
     * @return a String of at least one character
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();

            if (response.length() > 0)
                done = true;
            else
                System.out.println("\nYou must enter at least one character!\n");

        } while (!done);

        return response;
    }

    /**
     * get an int val from the user with no constraints
     * @param pipe   Scanner to use for the input
     * @param prompt msg to user for what to enter
     * @return any valid int
     */
    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        int value = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        } while (!done);

        return value;
    }

    /**
     * returns an unrestrained double value
     * @param pipe   Scanner to use for input
     * @param prompt msg to user for what to enter
     * @return any valid double
     */

    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        double value = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        } while (!done);

        return value;
    }

    /**
     * gets an int val from the user with no constraints
     * @param pipe   Scanner to use for input
     * @param prompt msg to user for what to enter
     * @param low    low value for the input range
     * @param high   high value for the input range
     * @return any valid int
     */

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        String trash = "";
        int value = 0;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();

                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]: ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        } while (!done);

        return value;
    }

    /**
     * Gets a double value within an inclusive range
     *
     * @param pipe   Scanner to use for input
     * @param prompt msg to user about what to enter
     * @param low    low bound of inclusive range
     * @param high   high bound of inclusive range
     * @return a double within the inclusive range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        String trash = "";
        double value = 0;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();

                if (value >= low && value <= high)
                    done = true;

                else
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]: ");

            }else
                trash = pipe.nextLine();
            System.out.println("\nYou must enter a number. You entered: " + trash);

        } while (!done);

        return value;
    }

    /**
     * Returns a true false value for yes or no input
     * @param pipe Scanner to read the input
     * @param prompt msg to tell the user what to input
     * @return a boolean true or false for yes or no
     */

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean done = false;
        boolean retVal = false;
        String response = "";

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();

            if (response.toUpperCase().matches("[YN]")) {
                done = true;

                if (response.equalsIgnoreCase("Y"))
                    retVal = true;

                else
                    retVal = false;
            }else
                System.out.println("\nYou must enter a [y/n]!\n");

        } while (!done);

        return retVal;
    }

    /**
     * takes a regEX String and returns a valid match from the user
     * @param pipe Scanner to use for input
     * @param prompt msg to user telling them what is needed for input
     * @param regEx a String that represents a regular expression to use for the
     * @return a String value that matches the regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + " " + regEx + ": ");
            response = pipe.nextLine();

            if (response.matches(regEx))
                done = true;
            else
                System.out.println("\nYou must enter a String that matches the pattern " + regEx + "!\n");

        } while (!done);

        return response;
    }
}
