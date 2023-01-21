import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        String J, S = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            J = reader.readLine();
            S = reader.readLine();
            Set<Character> jSet=new HashSet<>();
            for(char cj:J.toCharArray()){
                jSet.add(cj);
            }


            for (char cj : jSet) {
                for (char cs : S.toCharArray()) {
                    if (cj == cs) {

                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}