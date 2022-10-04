import java.util.Scanner;

public class MICS_2015_Problem_3 {
    //Steganography problem, solve using modulus and an array of char

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] characters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".", "?", "\n"};
        String output = "";

        while(scan.hasNextInt())
        {
            int character = scan.nextInt();
            output += characters[character % 30];
        }

        System.out.println(output);
        scan.close();
    }
}
