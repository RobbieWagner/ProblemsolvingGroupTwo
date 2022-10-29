import java.util.ArrayList;

public class Word {

    public final String word;
    public ArrayList<String> unaddableWords;
    public final int weight;
    public boolean isLeaf;
    public Word lastWord;

    public Word(String word, ArrayList<String> unaddableWords, int weight, boolean isLeaf, Word lastWord) {
        this.word = word;
        this.unaddableWords = unaddableWords;
        this.weight = weight;
        this.isLeaf = isLeaf;
        this.lastWord = lastWord;
    }

    public void isNoLongerLeaf() {
        isLeaf = false;
    }

    public String wordToString() {
        return word;
    }

    public String unaddableWordsToString() {
        final StringBuilder unaddableWordsStringBuilder = new StringBuilder();
        for(String currentUnaddableWordString : unaddableWords) {
            unaddableWordsStringBuilder.append("%s ".formatted(currentUnaddableWordString));
        }
        return unaddableWordsStringBuilder.toString();
    }

    public String weightToString() {
        return "%d".formatted(weight);
    }

    public String isLeafToString() {
        return isLeaf ? "True" : "False";
    }

    public String lastWordToString() {
        return lastWord.wordToString();
    }

    public String toString() {
        return ("""
                Word: %s
                Previous word: %s
                Weight: %s
                %s a leaf
                Unaddable words: %s
                """).formatted(wordToString(), lastWordToString(), weightToString(),
                               isLeaf ? "Is" : "Is not", unaddableWordsToString());
    }

}
