import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        String J, S = null;
        int n;
        int[]initVolumes;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            J = reader.readLine();
            S = reader.readLine();
            System.out.println("J "+J+" S "+S);
            n=Integer.parseInt(J);
            initVolumes=new int[n];
            for(int i=0;i<S.length();i++){
                initVolumes[i]=S.charAt(i);
                System.out.println(initVolumes[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}