import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine;
        int res = 0;
        int min1 = 0, max1 = 0, min2 = 0, max2 = 0;
        while((currentLine = reader.readLine()) != null){
            int i = 0;
            while(currentLine.charAt(i) != '-'){
                if(min1 == 0)
                    min1 = Character.getNumericValue(currentLine.charAt(i));
                else
                    min1 = (min1 * 10) + Character.getNumericValue(currentLine.charAt(i));
                i++;
            }
            i++;
            while(currentLine.charAt(i) != ','){
                if(max1 == 0)
                    max1 = Character.getNumericValue(currentLine.charAt(i));
                else
                    max1 = (max1 * 10) + Character.getNumericValue(currentLine.charAt(i));
                i++;
            }
            i++;
            while(currentLine.charAt(i) != '-'){
                if(min2 == 0)
                    min2 = Character.getNumericValue(currentLine.charAt(i));
                else
                    min2 = (min2 * 10) + Character.getNumericValue(currentLine.charAt(i));
                i++;
            }
            i++;
            while(i < currentLine.length()){
                if(max2 == 0)
                    max2 = Character.getNumericValue(currentLine.charAt(i));
                else
                    max2 = (max2 * 10) + Character.getNumericValue(currentLine.charAt(i));
                i++;
            }

            if((min1 <= min2 && max1 >= max2) || (min2 <= min1 && max2 >= max1))
                res++;

            min1 = 0;
            max1 = 0;
            min2 = 0;
            max2 = 0;
        }
        reader.close();
        System.out.println(res);
    }
}
