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

}
