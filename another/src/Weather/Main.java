package Weather;

import aircraft.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    private  static WeatherTower weatherTower;

    public static void main(String[] args){

        if (args.length > 0) {
            String arg = args[0];
            String fileName = args[0];

            String line = null;

            try {
                FileReader fileReader =
                        new FileReader(fileName);

                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);
                line = bufferedReader.readLine();
                int simulations = Integer.parseInt(line);

                weatherTower = new WeatherTower();
                while ((line = bufferedReader.readLine()) != null) {
                    String [] yo = line.split(" ");
                    Flyable aircraft = AircraftFactory.newAicraftFactory(yo[0], yo[1], Integer.parseInt(yo[2]), Integer.parseInt(yo[3]), Integer.parseInt(yo[4]));
                    if (aircraft != null)
                    {
                        aircraft.registerTower(weatherTower);
                    }
                    else
                    {
                        System.out.println("This aircraft is shit");
                    }
                }

                for (int c=0; c<simulations; c++)
                {
                    weatherTower.changeWeather();
                }

                bufferedReader.close();



            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
            }
        }

//        instantiate from Classes
//        WeatherTower t = new WeatherTower();
//        Flyable x = AircraftFactory.newAicraftFactory("BALLOON", "B1", 12, 3, 3);
//        Flyable w = AircraftFactory.newAicraftFactory("JETPLANE", "J1", 13, 4, 2);
//        Flyable y = AircraftFactory.newAicraftFactory("HELICOPTER", "J1", 14, 5, 4);
//
//
//        System.out.println("The first one");
//        x.registerTower(t);
//        System.out.println("Before");
//        t.display();
//        t.unregister(x);
//        System.out.println("After");
//        t.display();
//
//
//        System.out.println("-------------------------------------------------------------Yo------------------------------");
//        System.out.println("Another one");
//        w.registerTower(t);
//        System.out.println("Before");
//        t.display();
//        t.unregister(w);
//        System.out.println("After");
//        t.display();
//
//        System.out.println("-------------------------------------------------------------Yo------------------------------");
//        System.out.println("And Another one++");
//       y.registerTower(t);
//        System.out.println("Before");
//        t.display();
//        t.unregister(y);
//        System.out.println("After");
//        t.display();








        //check if aircrafts are registered properly






    }

    //instantiate factory
    //create dummy aircraft



    //check if first line is int
    //if it's a valid aircraft
    //if it's the right amount of arguments in each line
    // if all are positive ints
}
