import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MICS_2015_Problem_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        int output = countNumbersWith8Divisors(input);
        System.out.println(output);

        scan.close();
    }

    public static int countNumbersWith8Divisors(int number) {

        if(number < 24)
            return 0;

        int numbersWith8Divisors = 0;
        for(int i = 24; i <= number; i++) {
            ArrayList<Integer> powers = new ArrayList<>();
            int divisors = PrimeFactorize(i, powers);
            if (divisors == 8) {
                numbersWith8Divisors++;
            }
        }

        return numbersWith8Divisors;
    }

//    public static int countDivisors(int number){
//        int divisors = 2;
//
//        for(int i = 2; i <= number/2; i++){
//            if(number % i == 0) divisors++;
//        }
//        return divisors;
//    }

    public static int PrimeFactorize(int input, List<Integer> powers) {
        int number = input;
        powers.add(0);

        while(number % 2 == 0) {
            number /= 2;
            powers.set(0, powers.get(0) + 1);
        }
        for(int currentFactor = 3; currentFactor <= Math.sqrt(number); currentFactor += 2) {
            int currentIndex = powers.size();
            powers.add(0);

            while(number % currentFactor == 0) {
                number /= currentFactor;
                powers.set(currentIndex, powers.get(currentIndex) + 1);
            }
        }

        // The remaining number is either 1 or the final factor
        if(number != 1) {
            powers.add(1);
        }

        int result = 1;

        for(int power : powers) {
            result *= power + 1;
        }

        return result;
    }
}
