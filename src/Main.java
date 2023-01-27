import java.io.*;
public class Main {

    public static void main(String[] args) {
       Input input=new Input();
       input.getInput();
       input.analize();
    }


    public static class Input {
        int nrOfRows;
        char[][] seats;
        int nrOfGroups;
        String[][] groups;

        public void getInput() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                nrOfRows = Integer.parseInt(reader.readLine());
                seats = new char[nrOfRows][7];
                for (int i = 0; i < nrOfRows; i++) {
                    String row = reader.readLine();
                    for (int j = 0; j < 7; j++) {
                        seats[i][j] = row.charAt(j);
                    }
                }
                nrOfGroups = Integer.parseInt(reader.readLine());
                groups = new String[nrOfGroups][3];
                for (int k = 0; k < nrOfGroups; k++) {
                    String groupString = reader.readLine();
                    String[] in = groupString.split(" ");
                    for (int l = 0; l < 3; l++) {
                        groups[k][l] = in[l];
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void analize() {
            for (int i = 0; i < nrOfGroups; i++) {
                String[] group = groups[i];
                int quantity = Integer.parseInt(group[0]);
                String side = group[1];
                String preference = group[2];
                if (side.equals("left") && preference.equals("aisle")) {
                    for (int j = 0; j < nrOfRows; j++) {
                        if (seats[j][2] == '.' && quantity == 1) {
                            seats[j][2] = 'X';
                            break;
                        }
                        if (seats[j][2] == '.' && seats[j][1] == '.' && quantity == 2) {
                            seats[j][2] = 'X';
                            seats[j][1] = 'X';
                            break;
                        }
                        if (seats[j][2] == '.' && seats[j][1] == '.' && seats[j][0] == '.' && quantity == 3) {
                            seats[j][2] = 'X';
                            seats[j][1] = 'X';
                            seats[j][0] = 'X';
                            break;
                        }
                    }

                    display();
                }
                if (side.equals("left") && preference.equals("window")) {
                    for (int j = 0; j < nrOfRows; j++) {
                        if (seats[j][0] == '.' && quantity == 1) {
                            seats[j][0] = 'X';
                            break;
                        }
                        if (seats[j][0] == '.' && seats[j][1] == '.' && quantity == 2) {
                            seats[j][0] = 'X';
                            seats[j][1] = 'X';
                            break;
                        }
                        if (seats[j][0] == '.' && seats[j][1] == '.' && seats[j][2] == '.' && quantity == 3) {
                            seats[j][2] = 'X';
                            seats[j][1] = 'X';
                            seats[j][0] = 'X';
                            break;
                        }
                    }
                    display();
                }
                if (side.equals("right") && preference.equals("aisle")) {
                    for (int j = 0; j < nrOfRows; j++) {
                        if (seats[j][4] == '.' && quantity == 1) {
                            seats[j][4] = 'X';
                            break;
                        }
                        if (seats[j][4] == '.' && seats[j][5] == '.' && quantity == 2) {
                            seats[j][4] = 'X';
                            seats[j][5] = 'X';
                            break;
                        }
                        if (seats[j][4] == '.' && seats[j][5] == '.' && seats[j][6] == '.' && quantity == 3) {
                            seats[j][4] = 'X';
                            seats[j][5] = 'X';
                            seats[j][6] = 'X';
                            break;
                        }
                    }
                    display();
                }
                if (side.equals("right") && preference.equals("window")) {
                    for (int j = 0; j < nrOfRows; j++) {
                        if (seats[j][6] == '.' && quantity == 1) {
                            seats[j][6] = 'X';
                            break;
                        }
                        if (seats[j][6] == '.' && seats[j][5] == '.' && quantity == 2) {
                            seats[j][6] = 'X';
                            seats[j][5] = 'X';
                            break;
                        }
                        if (seats[j][6] == '.' && seats[j][5] == '.' && seats[j][4] == '.' && quantity == 3) {
                            seats[j][6] = 'X';
                            seats[j][5] = 'X';
                            seats[j][4] = 'X';
                            break;
                        }
                    }
                    display();
                }


            }

        }


        public void display() {
            if (containsX()) {
                System.out.println("Passengers can take seats: " + getSeats());
                for (int i = 0; i < nrOfRows; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(seats[i][j]);
                    }
                    System.out.println();
                }
                updateSeats();
            } else {
                System.out.println("Cannot fulfill passengers requirements");
            }
        }

        public boolean containsX() {
            for (int i = 0; i < nrOfRows; i++) {
                for (int j = 0; j < 7; j++) {
                    if (seats[i][j] == 'X') {
                        return true;
                    }
                }
            }
            return false;
        }

        public void updateSeats() {
            for (int i = 0; i < nrOfRows; i++) {
                for (int j = 0; j < 7; j++) {
                    if (seats[i][j] == 'X') {
                        seats[i][j] = '#';
                    }
                }
            }
        }

        public String getSeats() {
            String st = "";
            for (int i = 0; i < nrOfRows; i++) {
                for (int j = 0; j < 7; j++) {
                    if (seats[i][j] == 'X') {
                        String row = String.valueOf(i + 1);
                        String place = getPlace(j);
                        st = st + row + place+" ";
                    }
                }

            }
            return st;

        }

        public String getPlace(int num) {
            if (num == 0) {
                return "A";
            }
            if (num == 1) {
                return "B";
            }
            if (num == 2) {
                return "C";
            }
            if (num == 4) {
                return "D";
            }
            if (num == 5) {
                return "E";
            }
            if (num == 6) {
                return "F";
            }
            else{
                return "";
            }
        }
    }
}





