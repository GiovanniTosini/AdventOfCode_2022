import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String line = reader.readLine();
        Set<Character> s1 = new HashSet<>();
        int i = 0;
        for(; i < (line.length() - 13); i++){
            for(int j = i; j < (i + 14); j++){
                s1.add(line.charAt(j));
            }
            if(s1.size() == 14)
                break;
            s1.clear();
        }
        System.out.println(i+14);
    }
}
