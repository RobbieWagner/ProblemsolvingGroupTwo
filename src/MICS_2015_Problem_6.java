import java.util.*;
import java.util.Scanner;

public class MICS_2015_Problem_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> input = new ArrayList<String>();

        while(scan.hasNextLine()) {
            input.add(scan.nextLine());
        }

        for(String inputString: input) {
            reformatForFunction(inputString);
        }

        scan.close();
    }

    public static void reformatForFunction(String input) {
        String[] passwordAndRequiredLength = input.split(" ");

        String password = passwordAndRequiredLength[0];
        int requiredLength = Integer.parseInt(passwordAndRequiredLength[1]);

        lengthenPassword(password, requiredLength);
    }

    private static void lengthenPassword(String password, int requiredLength) {
        char[] passwordCharacters = password.toCharArray();
        List<Character> newPassword = new ArrayList<Character>();

        int base = 9;

        //for each character in passwordCharacters
        //if character is an integer >= base
        //convert integer to base and add it to the new password list
        //else add character to newPassword
        //if newPassword.length == required length
        //done, print newPassword characters and length
    }

    public static int convertFromBaseTen(int input, int baseTo) {
        int output = 0;
        int digit = 0;

        while (input > 0) {
            output += (int) (input % baseTo * Math.pow(10, digit));
            input /= baseTo;
            digit++;
        }

        //System.out.println(output);
        return output;
    }

    public static int convertToBaseTen(int input, int baseFrom) {
        int output = 0;
        int digit = 0;

        while (input > 0) {
            output += (int) input % (10) * Math.pow(baseFrom, digit);
            input /= 10;
            digit++;
        }

        //System.out.println(output);
        return output;
    }
}
