package Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Weather.*;
import aircraft.*;

public class checker {
    public static void main(String[] args) {

        try {

            if (args.length > 0) {
                String arg = args[0];
                System.out.println(arg);
                String fileName = args[0];

                // This will reference one line at a time
                String line = null;

                try {
                    // FileReader reads text files in the default encoding.
                    FileReader fileReader =
                            new FileReader(fileName);

                    // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    line = bufferedReader.readLine();
                    //error handling to check whether simulation is a positive int or not
                    int isNum = Integer.parseInt(line);
                    if (isNum < 0){
                        System.out.println(" Invalid number.Has to be a positive number");
                    } else {
                        System.out.println(isNum);
                    }

                    //error handling
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                }  catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");
                System.exit(1);
            } catch (IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
                    System.exit(1);
            } catch (NumberFormatException e){
                    System.out.println("A non-integer value was given for number of simulations!!");
                    System.exit(1);
                }
            }

            }
         catch (Exception e) {
            System.out.println("yo");
        }
    }
}
