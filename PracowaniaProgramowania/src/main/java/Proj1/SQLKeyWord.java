package Proj1;

import javax.swing.text.Position;

public class SQLKeyWord {
    int position;
    String keyWord;

    public SQLKeyWord(int position, String keyWord) {
        this.position = position;
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public int getKeyWordPower(){
        int a = 0;
        if (keyWord.equals("select")) {
            a = 1;
        }
        if (keyWord.equals("from")) {
            a = 2;
        }
        if (keyWord.equals("where")) {
            a = 3;
        }
        if (keyWord.equals("order by")) {
            a = 4;
        }
        return a;
    }
}
