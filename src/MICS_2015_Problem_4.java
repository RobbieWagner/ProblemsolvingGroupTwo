import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MICS_2015_Problem_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        int output = countNumbersWith8Divisors(input);


        scan.close();
    }

    public static int countNumbersWith8Divisors(int number){

        if(number < 24)
            return 0;

        int numbersWith8Divisors = 0;
        for(int i = 24; i <= number; i++)
        {
            ArrayList<Integer> powers = new ArrayList<>();
            PrimeFactorize(i, powers);
        }

        return numbersWith8Divisors;
    }
//
//    public static int countDivisors(int number){
//        int divisors = 2;
//
//        for(int i = 2; i <= number/2; i++){
//            if(number % i == 0) divisors++;
//        }
//        return divisors;
//    }

    public static void PrimeFactorize(int input, List<Integer> powers) {
        int number = input;
        int powersIndex = 0;
        powers.add(0);

        while(number % 2 == 0){
            number /= 2;
            powers.set(0, powers.get(0) + 1);
        }
        for(int i = 3; i < input/2; i+=2){

            int currentIndex = powers.size();
            powers.add(0);

            while(number % i == 0){
                number /= i;
                powers.set(currentIndex, powers.get(currentIndex) + 1);
            }
        }

    }
}
