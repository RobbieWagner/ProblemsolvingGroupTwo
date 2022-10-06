import java.util.Scanner;

public class MICS_2015_Problem_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        int output = countNumbersWith8Divisors(input);

        System.out.println(output);


        scan.close();
    }

    public static int countNumbersWith8Divisors(int number){

        if(number < 24)
            return 0;

        int numbersWith8Divisors = 0;
        for(int i = 24; i <= number; i++)
        {
            if(numberHas8Divisors(i))
                numbersWith8Divisors++;
        }

        return numbersWith8Divisors;
    }

    public static boolean numberHas8Divisors(int number){
        int divisors = 2;

        for(int i = 2; i <= number/2; i++){
            if(number % i == 0) divisors++;
        }
        if(divisors == 8) return true;
        return false;
    }
}
