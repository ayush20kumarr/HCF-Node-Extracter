import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\ayushk\\Downloads\\nodesDown.txt");
        File outputFile = new File("C:\\Users\\ayushk\\Downloads\\HFC_Node_down.txt");

        try (Scanner scanner = new Scanner(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String formattedLine = formatLine(line);
                writer.write(formattedLine + "\n");
            }

            System.out.println("File has been written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatLine(String line) {
        if (line.length() != 5) {
            throw new IllegalArgumentException("Line must be exactly 5 digits long");
        }
        return "JM-" + line.substring(0, 2) + "-" + line.substring(2);
    }
}
