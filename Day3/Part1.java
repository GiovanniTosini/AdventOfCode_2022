import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) throws IOException {

        /*
        here I make the alphabet I'll use it for the index, it will be useful for
        the priority required by the problem
         */
        char[] alphabet = new char[52];
        char a = 'a';
        char A = 'A';
        for(int i = 0; i < 26; i++){
            alphabet[i] = a;
            a++;
        }
        for(int i = 26; i < 52; i++){
            alphabet[i] = A;
            A++;
        }

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine;
        Set<Character> c1 = new HashSet<>();
        Set<Character> c2 = new HashSet<>();
        int cursor;
        int res = 0;
        while((currentLine = reader.readLine()) != null){
            cursor = currentLine.length();
            /*
            fill the two sets, c1 will be filled with
            the first part of the string, while c2 will
            be filled with the second one
            line 42 is filling c2 from the end minus the value of i
             */
            for(int i = 0; i < (cursor / 2); i++){
                c1.add(currentLine.charAt(i));
                c2.add(currentLine.charAt((cursor - 1) - i));
            }
            for(char c : c1){
                if(c2.contains(c)){
                    res += (new String(alphabet).indexOf(c)) + 1;
                    c1.clear();
                    c2.clear();
                    break;
                }
            }
        }

        reader.close();
        System.out.println(res);
    }
}
