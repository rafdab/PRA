package Proj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQLChecker {
    static void start(){
        Scanner scan = new Scanner(System.in);

        //System.out.print("Podaj numer zadania: ");
        //int nrZad = scan.nextInt();
        System.out.println("Podaj rozwiązanie:");
        String sql = scan.nextLine();
        final boolean b = checkSql(sql);
    }

    static boolean checkSql(String input){
        String keyWordTable[] = {"select", "from", "where", "orderby"};
        List<SQLKeyWord> keyWordList = new ArrayList<SQLKeyWord>();
        int count = 0;
        input = input.toLowerCase();
        String sql[] = null;
        sql = input.split(" ");
        for (int j = 0; j < keyWordTable.length; j++){
            for (int i = 0; i < sql.length; i++) {
                if (keyWordTable[j].equals(sql[i])){
                    keyWordList.add(new SQLKeyWord(i, sql[i]));
                    count += 1;
                }
            }
        }
        System.out.println(keyWordList.get(count-1).getPosition());
        return true;
    }
}
