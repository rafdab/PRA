package Proj1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.*;

public class SQLChecker {
    static boolean start(){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> queryList = new ArrayList<String>();
        int queryCount = 0;

        System.out.print("Podaj numer zadania: ");
        int nrZad = scan.nextInt();
        if (nrZad == 0) return false;

        System.out.println("Podaj rozwiązanie:");
        String sql;
        scan.nextLine();
        sql = scan.nextLine();
        if (sql.equals("STOP") || sql.equals("stop")) return false;

        if(checkSql(sql)){
            System.out.println("Twoje zapytanie wygląda poprawnie.");
            sql = nrZad + " " + sql;
            queryList.add(queryCount, sql);
            Collections.sort(queryList);
            queryCount++;
        }
        else {
            System.out.println("Niepoprawna składnia zapytania, spróbuj ponownie.");
        }

        System.out.println(queryCount);
        for (int i = 0; i < queryCount; i++) {
            System.out.println(queryList.get(i));
        }
        /*
        try {
            saveToFile(queryList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
        return true;
    }

    private static boolean checkSql(String input){
        String keyWordTable[] = {"select", "from", "where", "order by"};
        List<SQLKeyWord> keyWordList = new ArrayList<SQLKeyWord>();
        int count = 0;
        input = input.toLowerCase();
        String sql[] = null;
        sql = input.split(" ");

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < sql.length; j++){
                if (sql[j].equals("order") && sql[j + 1].equals("by")) {
                    sql[j] += " by";
                    j++;
                }
                if (keyWordTable[i].equals(sql[j])){
                    keyWordList.add(new SQLKeyWord(j,sql[j]));
                    count++;
                }
            }
        }
        if (count > 4 || count < 1) {
            return false;
        }
        for(int i = 0; i < count-1; i++){
            if ((keyWordList.get(i).getPosition() > keyWordList.get(i+1).getPosition()) && (keyWordList.get(i).getKeyWordPower() < keyWordList.get(i+1).getKeyWordPower())) {
                return false;
            }
        }
        return true;
    }

    static void saveToFile(ArrayList<String> data, int count) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("odp.txt", "UTF-8");
        for (String tmp : data) {
            writer.println(tmp);
        }
        writer.close();
    }
}
