import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class DoubletsProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> dictionaryWords = new ArrayList<String>();
        ArrayList<String> inputWords = new ArrayList<String>();

        boolean done = false;

        //creates dictionary
        while(!done) {
            dictionaryWords.add(scan.nextLine().toLowerCase());
            if(dictionaryWords.get(dictionaryWords.size() - 1).equals("")) {
                done = true;
            }
        }

        //removes blank line
        dictionaryWords.remove(dictionaryWords.size() - 1);

        done = false;
        //adds in input for finding doublets
        while(!done && scan.hasNextLine()) {
            inputWords.add(scan.nextLine());
            if(inputWords.get(inputWords.size() - 1).equals("")) done = true;
        }

        scan.close();



//        for(int i = 0; i < dictionaryWords.size(); i++) {
//            System.out.println(dictionaryWords.get(i));
//        }

        for(String inputString : inputWords) {
            String[] wordToFrom = splitString(inputString);
            FindPath(wordToFrom[0], wordToFrom[1], dictionaryWords);
        }

        //for(int i = 0; i < inputWords.size(); i +=2 ){
        //    FindPath(inputWords.get(i), inputWords.get(i+1), dictionaryWords);
        //}

    }

    public static void FindPath(String firstWord, String finalWord, ArrayList<String> dictionaryWords) {
        ArrayList<String> sameLengthWords = findSameLengthWords(dictionaryWords, firstWord.length());

        if(firstWord.length() != finalWord.length() || !dictionaryWords.contains(firstWord) || !dictionaryWords.contains(finalWord)) System.out.println("no solution");
        else {
            ArrayList<Word> wordTree = new ArrayList<Word>();
            System.out.println(firstWord + " 1");

            Word startWord = new Word(firstWord, new ArrayList<String>(), 0, true, null);
            boolean doneSearching = false;
            Word currentWord = startWord;

            while(!doneSearching)
            {
                addChildren(firstWord, wordTree, currentWord, sameLengthWords, finalWord);
                doneSearching = true;
            }
            // check if the added words contain the goal word
            // if all tree words are not leaves, no solution can be found.
        }
    }

    // adds children of a word to the tree, creating new word objects
    public static void addChildren(String startWord, ArrayList<Word> currentTree, Word parentWord, ArrayList<String> dictionaryWords, String finalWord){
        ArrayList<String> wordsWithOneLetterDifference = findWordsWithOneLetterDifference(dictionaryWords, parentWord.word);
        ArrayList<Word> addedWords = new ArrayList<Word>();

        //Check to see if the parent word has unaddable words
        if(parentWord.unaddableWords != null) {
            for (String string : wordsWithOneLetterDifference) {
                if(!parentWord.unaddableWords.contains(string)) {
                    Word wordToAdd = new Word(string, new ArrayList<String>(), findWeight(startWord, parentWord.word, string, finalWord), true, parentWord);
                    addedWords.add(wordToAdd);
                    System.out.println(wordToAdd.toString());
                }
            }
        }
        else {
            for (String string : wordsWithOneLetterDifference) {
                Word wordToAdd = new Word(string, new ArrayList<String>(), findWeight(startWord, parentWord.word, string, finalWord), true, parentWord);
                addedWords.add(wordToAdd);
                //System.out.println(wordToAdd.toString());
            }
        }

        for(Word addedWord : addedWords) {
            addedWord.unaddableWords.add(parentWord.word);
            if(parentWord.unaddableWords != null) {
                for(String unaddableWord : parentWord.unaddableWords) {
                    addedWord.unaddableWords.add(unaddableWord);
                    System.out.println(addedWord.unaddableWordsToString().length());
                    System.out.println(addedWord.toString());
                }
            }
            for (Word word : addedWords) {
                addedWord.unaddableWords.add(word.word);
            }
        }
        parentWord.isNoLongerLeaf();
    }

    public static ArrayList<String> findSameLengthWords(ArrayList<String> dictionary, int wordSize) {
        ArrayList<String> sameLengthDictionaryWords = new ArrayList<String>();

        for(int i = 0; i < dictionary.size(); i++){
            if(dictionary.get(i).length() == wordSize){
                sameLengthDictionaryWords.add(dictionary.get(i));
            }
        }

        return sameLengthDictionaryWords;
    }

    public static ArrayList<String> findWordsWithOneLetterDifference(ArrayList<String> dictionary, String word) {
        ArrayList<String> oneLetterDifferenceWords = new ArrayList<String>();
        for(String string: dictionary){
            if(isWord1LetterDifferent(string, word)){
                oneLetterDifferenceWords.add(string);
            }
        }
        return oneLetterDifferenceWords;
    }

    public static String[] splitString(String string) {
        return string.split(" ");
    }

    // finds the weight a new word should
    public static int findWeight(String startString, String parentString, String currentString, String goalString) {
        if(findCharacterDifference(parentString, goalString) > findCharacterDifference(currentString, goalString)) return 2;
        if(findCharacterDifference(parentString, startString) > findCharacterDifference(currentString, startString)) return 1;
        if(findCharacterDifference(parentString, goalString) == findCharacterDifference(currentString, goalString) &&
                findCharacterDifference(parentString, startString) == findCharacterDifference(currentString, startString)) return 0;
        return -1;
    }

    // returns the character difference amount between two words
    public static int findCharacterDifference(String word1, String word2)
    {
        char[] word1CA = word1.toCharArray();
        char[] word2CA = word2.toCharArray();

        int output = 0;

        for(int i = 0; i < word1CA.length; i++)
        {
            if(word1CA[i] != word2CA[i]) output++;
        }

        return output;
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

