import java.util.Arrays;
import java.util.Scanner;

public class MICS_2015_Problem_5 {
    public static void main(String[] args) {
        int[] input = inputIntArray();
        Arrays.sort(input);

        System.out.println(input.length);
        valleySort(input);
    }

    public static int[] inputIntArray() {
        Scanner scan = new Scanner(System.in);

        int inputLength = scan.nextInt();
        int[] input = new int[inputLength];

        for(int element = 0; element < inputLength; element++) {
            input[element] = scan.nextInt();
        }

        scan.close();

        return input;
    }

    public static void valleySort(int[] sortedArray) {
        int index = sortedArray.length - 1;
        while(index >= 0) {
            System.out.println(sortedArray[index]);
            index -=2;
        }

        //finds index for going back up the array
        index = index * -1 -1;

        while(index < sortedArray.length) {
            System.out.println(sortedArray[index]);
            index +=2;
        }

    }


}
