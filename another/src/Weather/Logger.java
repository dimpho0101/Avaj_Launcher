package Weather;
import aircraft.*;
import Weather.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static void print(String args) {
//        String content = "This is the content to write into file\n";

        // If the file doesn't exists, create and write to it
        // If the file exists, truncate (remove all content) and write to it
        try (FileWriter writer = new FileWriter("Simulation.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(args + "\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}

//make it a function
