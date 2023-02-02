import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.getInput();
        input.analyze();

        public void analyze () {
            int[] set = new int[setSize];
            sets = new HashSet<>();
            getAllSets(array, set, 0, arraySize, 0, setSize, sets);

            //display();
        }

        public void getAllSets ( int[] array, int[] set, int start, int end, int index, int setSize, Set<int[]>sets){

            if (index == setSize) {
                //setOfSet.push(set);
                sets.add(set);
                display();
                return;
            }
            for (int i = start; i < end; i++) {
                set[index] = array[i];
                getAllSets(array, set, i + 1, end, index + 1, setSize, sets);
            }
        }


        public void display () {
            System.out.println("display ");
/*
            while(!setOfSet.isEmpty()) {
                int[] item = setOfSet.pop();

                for (int i : item) {
                    System.out.print(i + " ");
                }
            }
*/

            for (int[] item : sets) {
                for (int i : item) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

        }
    }

    public static class Input {
        int arraySize;
        int setSize;
        int[] array;
        Stack<int[]> setOfSet;
        Set<int[]> sets;


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





        }



    }






