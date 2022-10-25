import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DoubletsProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> dictionaryWords = new ArrayList<String>();
        ArrayList<String> inputWords = new ArrayList<String>();

        boolean done = false;

        //creates dictionary
        while(!done) {
            dictionaryWords.add(scan.nextLine());
            if(dictionaryWords.get(dictionaryWords.size() - 1).equals("")) {
                done = true;
            }
        }

        //removes blank line
        dictionaryWords.remove(dictionaryWords.size() - 1);

        //adds in input for finding doublets
        while(scan.hasNextLine()) {
            inputWords.add(scan.nextLine());
        }

        scan.close();

        for(int i = 0; i < dictionaryWords.size(); i++) {
            System.out.println(dictionaryWords.get(i));
        }

        for(String inputString : inputWords) {
            String[] wordToFrom = splitString(inputString);
            FindPath(wordToFrom[0], wordToFrom[1]);
        }

    }

    public static void FindPath(String firstWord, String finalWord) {
        if(firstWord.length() != finalWord.length()) System.out.println("no solution");
        else {
            //build a "tree" starting with the firstWord
            //add words from the dictionary with the same length and one letter difference
                //(For optimization, consider creating a function that returns a list of strings with all words of same length)
            //prioritize words that get function closest to end result.
            //Follow words that look promising
                //Ex.) cat -> cad looks promising if the final word is end
            //Repeat until final word is reached.
                //Avoid re-adding words to the tree. Do not add a word if it already appears on the branch or on the level above.
            //After word is reached, keep going in case a better path can be found, ending when you reach a path that will for sure take longer*

            //*By grouping word changes by how much closer you get, we can find where to search next, and where to end.
            //*A path like cat->eat->ent->end will be the fastest possible because each letter change
            //*takes you one letter further from the first word and one closer to the final word.
        }
    }

    public static String[] splitString(String string) {
        return string.split(" ");
    }

    public static boolean isWord1LetterDifferent (String word1, String word2) {
        char[] charA1 = word1.toCharArray();
        char[] charA2 = word2.toCharArray();

        int differenceCount = 0;

        for(int i = 0; i < word1.length(); i++) {
            if(charA1[i] != charA2[i]) differenceCount++;
        }

        if(differenceCount == 1) return true;
        return false;
    }

}

