import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        try {
            Dictionary<String, String> fractal = new Hashtable<>();
            File f = new File(args[0]);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                String first = String.valueOf(temp.charAt(0));
                if (!first.equals("#")) {
                    if (temp.split(":").length == 2) {
                        String[] tempSplit = temp.split(":");
                        fractal.put(tempSplit[0].strip().toLowerCase(), tempSplit[1].strip().toLowerCase());
                    }
                }
            }
            CreateFrame frame = new CreateFrame(fractal);
            frame.initializeFrame(fractal);
        } catch (FileNotFoundException e) {
            System.out.println("Could not fine the file");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input a file");
            e.printStackTrace();
        }
    }
}