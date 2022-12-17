import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Part2 {
    public static void main(String[] args) throws IOException {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();
        Stack<Character> s4 = new Stack<>();
        Stack<Character> s5 = new Stack<>();
        Stack<Character> s6 = new Stack<>();
        Stack<Character> s7 = new Stack<>();
        Stack<Character> s8 = new Stack<>();
        Stack<Character> s9 = new Stack<>();

        String a1 = "HBVWNMLP";
        String a2 = "MQH";
        String a3 = "NDBGFQML";
        String a4 = "ZTFQMWG";
        String a5 = "MTHP";
        String a6 = "CBMJDHGT";
        String a7 = "MNBFVR";
        String a8 = "PLHMRGS";
        String a9 = "PDBCN";

        Part2.stackFiller(s1, a1);
        Part2.stackFiller(s2, a2);
        Part2.stackFiller(s3, a3);
        Part2.stackFiller(s4, a4);
        Part2.stackFiller(s5, a5);
        Part2.stackFiller(s6, a6);
        Part2.stackFiller(s7, a7);
        Part2.stackFiller(s8, a8);
        Part2.stackFiller(s9, a9);

        Stack<Character>[] crates = new Stack[9];
        crates[0] = s1;
        crates[1] = s2;
        crates[2] = s3;
        crates[3] = s4;
        crates[4] = s5;
        crates[5] = s6;
        crates[6] = s7;
        crates[7] = s8;
        crates[8] = s9;

        BufferedReader reader = new BufferedReader(new FileReader("puzzleInput.txt"));
        String currentLine;
        int howMany, from, to;
        while((currentLine = reader.readLine()) != null){
            howMany = Character.getNumericValue(currentLine.charAt(5));
            if(currentLine.charAt(6) != ' '){
                howMany = (howMany * 10) + Character.getNumericValue(currentLine.charAt(6));
                from = Character.getNumericValue(currentLine.charAt(13));
                to = Character.getNumericValue(currentLine.charAt(18));
                Part2.stackMover(crates[from - 1], crates[to - 1], howMany);
            }
            else{
                from = Character.getNumericValue(currentLine.charAt(12));
                to = Character.getNumericValue(currentLine.charAt(17));
                Part2.stackMover(crates[from - 1], crates[to - 1], howMany);
            }
        }
        reader.close();
        System.out.println(crates[0].pop());
        System.out.println(crates[1].pop());
        System.out.println(crates[2].pop());
        System.out.println(crates[3].pop());
        System.out.println(crates[4].pop());
        System.out.println(crates[5].pop());
        System.out.println(crates[6].pop());
        System.out.println(crates[7].pop());
        System.out.println(crates[8].pop());

    }

    static void stackMover(Stack<Character> from, Stack<Character> to, int howMany){

        Stack<Character> dummy = new Stack<>();
        for(int i = 0; i < howMany; i++)
            dummy.push(from.pop());
        for(int i = 0; i < howMany; i++)
            to.push(dummy.pop());
    }

    static void stackFiller(Stack<Character> s, String a){
        for(int i = 0; i < a.length(); i++)
            s.push(a.charAt(i));
    }
}


