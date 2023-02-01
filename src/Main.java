import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
       Input input=new Input();
       input.getInput();
       input.analyze();
    }

    public static class Input {
        int arraySize;
        int setSize;
        int[] array;
        Stack<int[]> setOfSet;
        List<int[]> sets;


        public void getInput() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                String firstString =reader.readLine();
                String[] in=firstString.split(" ");
                arraySize=Integer.parseInt(in[0]);
                setSize=Integer.parseInt(in[1]);
                array=new int[arraySize];
                String secondString= reader.readLine();
                String [] arrayIn=secondString.split(" ");
                for(int i=0;i<arrayIn.length;i++){
                    array[i]=Integer.parseInt(arrayIn[i]);
                }
                setOfSet=new Stack<>();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        public void analyze() {
            int[] set=new int[setSize];
            sets=new LinkedList<>();
            getAllSets(array,set,0,arraySize,0,setSize);
            //display();
        }

            public void getAllSets(int[] array,int[]set,int start, int end,int index,int setSize){

            if(index==setSize){
                setOfSet.push(set);
                sets.add(set);
                display();

/*
                int[]item=setOfSet.peek();
                for (int j:item) {
                    System.out.print(j + " ");
                }
                System.out.println("");
*/
                return;
            }
            for(int i=start;i<end;i++){
                set[index]=array[i];
                getAllSets(array,set,i+1,end,index+1,setSize);
            }
        }


        public void display() {
            System.out.print("display ");
/*
            while(!setOfSet.isEmpty()) {
                int[] item = setOfSet.pop();

                for (int i : item) {
                    System.out.print(i + " ");
                }
            }
*/

          for(int[] item:sets){
              for (int i : item) {
                  System.out.print(i + " ");
              }
          }


        }



    }
}





