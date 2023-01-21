import java.io.*;

public class Main {
    public static void main(String[] args) {
        String input = getInput();
        String[] in = input.split(" ");
        try {
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            String c=String.valueOf(a+b);
            FileWriter writer = new FileWriter("output.txt");
            for(char item:c.toCharArray()) {
                writer.write(item);
            }
            writer.close();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();

        }
    }

    public static String getInput(){
        String input = null;
        try{
            BufferedReader reader=new BufferedReader(new FileReader("input.txt"));
            input= reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }
}