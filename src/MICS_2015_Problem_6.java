public class MICS_2015_Problem_6 {
    public static void main(String[] args) {

    }

    public static int convertFromBaseTen(int input, int baseTo) {
        int output = 0;
        int digit = 0;

        while (input > 0) {
            digit++;

            output += (int) (input % baseTo * Math.pow(10, digit));
            input /= baseTo;
        }

        System.out.println(output);
        return output;
    }

    public static int convertToBaseTen(int input, int baseFrom) {
        int output = 0;
        int digit = 0;

        while (input > 0) {
            output += (int) input % (10) * Math.pow(baseFrom, digit);
            input /= 10;
        }

        System.out.println(output);
        return output;
    }
}
