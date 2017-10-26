package Proj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQLChecker {
    static boolean start(){
        Scanner scan = new Scanner(System.in);

        //System.out.print("Podaj numer zadania: ");
        //int nrZad = scan.nextInt();
        System.out.println("Podaj rozwiązanie:");
        String sql = scan.nextLine();
        if (sql.equals("STOP") || sql.equals("stop")) return false;
        if(checkSql(sql) == true){
            System.out.println("Twoje zapytanie wygląda poprawnie. Zapiesuję do pliku.");
        }
        else {
            System.out.println("Niepoprawna składnia zapytania, spróbuj ponownie.");
        }
        return true;
    }

    static boolean checkSql(String input){
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
}
