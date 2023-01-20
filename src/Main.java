import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String input=getInput();
        String[] in=input.split(" ");
        try{
            int a=Integer.parseInt(in[0]);
            int b=Integer.parseInt(in[1]);
            System.out.println(a+b);
        }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public static String getInput(){
        String input = null;
        System.out.print("enter two numbers split by space");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try{
            input= reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }
}