import java.io.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(makeEqual());
    }

    public static int makeEqual(){
        String J,S;
        int n;
        int[]initVolumes;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            J = reader.readLine();
            S = reader.readLine();
            n=Integer.parseInt(J);
            initVolumes=new int[n];
            String[] in = S.split(" ");
            for(int i=0;i<in.length;i++){
                initVolumes[i]=Integer.parseInt(in[i]);
            }
            for(int j=0;j< initVolumes.length-1;j++) {
                if (initVolumes[j] > initVolumes[j+1]) {
                    return -1;
                }
            }
           return initVolumes[initVolumes.length-1]- initVolumes[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


}