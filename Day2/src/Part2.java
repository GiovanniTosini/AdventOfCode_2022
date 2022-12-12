import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine;
        char enemy, end;
        int res = 0;
        /*
        enemy -> A = for Rock, B for Paper and C for Scissors
        end -> X = lose, Y = draw and Z = win
         */
        while((currentLine = reader.readLine()) != null){
            enemy = currentLine.charAt(0);
            end = currentLine.charAt(2);
            if(end == 'X'){
                if(enemy == 'A')
                    res += 3;
                else if(enemy == 'B')
                    res += 1;
                else
                    res += 2;
            }
            else if(end == 'Y'){
                res += 3;
                if(enemy == 'A')
                    res += 1;
                else if(enemy == 'B')
                    res += 2;
                else
                    res += 3;
            }
            else if(end == 'Z'){
                res += 6;
                if(enemy == 'A')
                    res += 2;
                else if(enemy == 'B')
                    res += 3;
                else
                    res += 1;
            }
        }
        reader.close();
        System.out.println(res);
    }
}
