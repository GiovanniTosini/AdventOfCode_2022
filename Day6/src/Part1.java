import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String line = reader.readLine();
        char c1 = line.charAt(0);
        char c2 = line.charAt(1);
        char c3 = line.charAt(2);
        char c4 = line.charAt(3);
        int res = 4;
        for(int i = 4; i < (line.length() - 3); i++){
            if(Part1.checkFour(c1, c2, c3, c4)){
                break;
            }
            res++;
            c1 = c2;
            c2 = c3;
            c3 = c4;
            c4 = line.charAt(i);
        }
        System.out.println(res);
    }
    public static boolean checkFour(char c1, char c2, char c3, char c4){
        return c1 != c2 && c1 != c3 && c1 != c4 && c2 != c3 && c2 != c4 && c3 != c4;
    }
}
