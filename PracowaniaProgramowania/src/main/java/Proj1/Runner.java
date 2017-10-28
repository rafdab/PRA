package Proj1;

import java.util.ArrayList;

import static Proj1.SQLChecker.*;

public class Runner {

    public static void main (String[] args){
        ArrayList<String> queryList = new ArrayList<>();

        System.out.println("Wpisz '0' lub 'stop' aby zakończyć\n");
        while(start(queryList));
    }
}
