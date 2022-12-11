import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Read one line from file, if is not empty add it to sum
when find one empty compare sum with res if sum is greater,
then res will take sum's value. The while condition is that
next line is different from null, null is EOF.
 */
public class Day1_Part1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine = reader.readLine();
        int res = 0; //final result
        int sum = 0; //temporary sum of one block of numbers
        do {
            if(!currentLine.isEmpty()){
                sum += Integer.parseInt(currentLine);
            }
            else{
                if(sum > res)
                    res = sum;
                sum = 0;
            }

        }
        while ((currentLine = reader.readLine()) != null);
        reader.close();
        System.out.println(res);
    }
}
