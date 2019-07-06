package aircraft;
import Weather.WeatherTower;

import static Weather.Logger.print;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    protected Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String x = weatherTower.getWeather(coordinates);

        if (x == "SNOW") {
          //  print("Helicopter#" + name + "(" +id+ "): winter is coming?");
           print("Helicopter#" + name + "(" +id+ "):  My rotor is going to freeze!");
            if (this.coordinates.getHeight() - 7 <= 0)
            {
                coordinates.setHeight(0);
               print("Helicopter#" + name + "(" +id+ "):  landing. ");
                weatherTower.unregister(this);
                print("Tower says: Helicopter#" + name + "(" + id + "): unregistered from weather tower.");
                return;
            } else {
              coordinates.setHeight(coordinates.getHeight() - 7);
            }
        } else if (x == "SUN") {
            print("Helicopter#" + name + "(" +id+ "):  This is hot.");
            if (this.coordinates.getHeight() + 2 <= 100)
            {
                coordinates.setHeight(100);
                print("Helicopter#" + name + "(" +id+ "): Cloud 9");
                weatherTower.unregister(this);
                print("Tower says: Helicopter#" + name + "(" + id + "): unregistered from weather tower.");
                return;
            } else {
                coordinates.setHeight(coordinates.getHeight() + 2);
            }
            coordinates.setLongitube(coordinates.getLongitube() + 10);
        }  else if (x == "RAIN") {
            print("Helicopter#" + name + "(" +id+ "): drip drip drip?");
            coordinates.setLongitube(coordinates.getLongitube() + 5);
        }  else if (x == "FOG") {
            print("Helicopter#" + name + "(" +id+ "): fog?");
            coordinates.setLongitube(coordinates.getLongitube() + 1);
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        print("Tower says: Helicopter#" + name + "(" + this.id + ") registered to weather tower");
        weatherTower.register(this);
    }
}
