import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day2input.txt");
        Scanner sc = new Scanner(file);
        int total = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] initial = line.split(":");
            int gameNumber = Integer.parseInt(initial[0].substring(5));
            String[] sets = initial[1].split(";");
            boolean addGameNumber = true;

            // looping through sets of each game
            for (int i = 0; i < sets.length; i++) {
                // System.out.println(sets[i]);
                String[] individualSet = sets[i].split(",");

                // looping through each cube color and number for each set
                for (int j = 0; j < individualSet.length; j++) {
                    // System.out.println(individualSet[j]);
                    int cubeValue = Integer.parseInt(individualSet[j].replaceAll("[^0-9]", ""));
                    // System.out.println(cubeValue);
                    String cubeColor = individualSet[j].replaceAll("[0-9]", "");
                    cubeColor = cubeColor.trim();
                    // System.out.println(cubeColor);

                    if (cubeColor.equals("green") && cubeValue > 13) { 
                            addGameNumber = false;
                            break;
                    }
                    if (cubeColor.equals("red") && cubeValue > 12) { 
                            addGameNumber = false;
                            break;
                    }
                    if (cubeColor.equals("blue") && cubeValue > 14) { 
                            addGameNumber = false;
                            break;
                    }
                
                    if (!addGameNumber) {
                        break;
                    }
                }

                if (!addGameNumber) {
                    break;
                }
            }

            if (addGameNumber) {
                total += gameNumber;
            }
        }
        
        System.out.println("TOTAL: " + total);
        sc.close();
    }
}
