import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Part2 {
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
        Set<Character> elf1 = new HashSet<>();
        Set<Character> elf2 = new HashSet<>();
        Set<Character> elf3 = new HashSet<>();
        int res = 0;
        while((currentLine = reader.readLine()) != null){
            for(int i = 0; i < currentLine.length(); i++){
                elf1.add(currentLine.charAt(i));
            }
            currentLine = reader.readLine();
            for(int i = 0; i < currentLine.length(); i++){
                elf2.add(currentLine.charAt(i));
            }
            currentLine = reader.readLine();
            for(int i = 0; i < currentLine.length(); i++){
                elf3.add(currentLine.charAt(i));
            }
            for(char c : elf1){
                if(elf2.contains(c) && elf3.contains(c)){
                    res += (new String(alphabet).indexOf(c)) + 1;
                    elf1.clear();
                    elf2.clear();
                    elf3.clear();
                    break;
                }
            }
        }
        reader.close();
        System.out.println(res);
    }
}
