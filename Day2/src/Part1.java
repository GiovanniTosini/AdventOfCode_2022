import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine;
        char enemy, mine;
        int res = 0;
        while((currentLine = reader.readLine()) != null){
            enemy = currentLine.charAt(0);
            mine = currentLine.charAt(2);
            /*
            Rock = +1
            Paper = +2
            Scissors = +3
             */
            switch (mine){
                case 'X':
                    res += 1;
                    break;
                case 'Y':
                    res += 2;
                    break;
                case 'Z':
                    res += 3;
                    break;
            }
            /*
            enemy -> A = for Rock, B for Paper and C for Scissors
            mine -> X = for Rock, Y for Paper and Z for Scissors
            lost = +0
            draw = +3
            win = +6
             */
            if( enemy == 'A' && mine == 'X')
                res += 3;
            else if(enemy == 'A' && mine == 'Y')
                res += 6;
            else if(enemy == 'B' && mine == 'Y')
                res += 3;
            else if(enemy == 'B' && mine == 'Z')
                res += 6;
            else if(enemy == 'C' && mine == 'X')
                res += 6;
            else if(enemy == 'C' && mine == 'Z')
                res += 3;
        }
        reader.close();
        System.out.println(res);
    }
}
