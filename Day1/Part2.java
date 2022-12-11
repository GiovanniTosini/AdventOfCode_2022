import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine = reader.readLine();
        int sum = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        do {
            if(!currentLine.isEmpty()){
                sum += Integer.parseInt(currentLine);
            }
            else{
                list.add(sum);
                sum = 0;
            }
        }
        while((currentLine = reader.readLine()) != null);
        reader.close();
        for(int i = 0; i < 3; i++){
            res += Collections.max(list);
            list.remove(Collections.max(list));
        }
        System.out.println(res);
    }
}
