package aircraft;
import Weather.WeatherTower;

import static Weather.Logger.print;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }


    public void updateConditions() {
        String x = weatherTower.getWeather(coordinates);

        if (x.equals("SNOW")) {
            print("Baloon#" + name + "(" +id+ "):  It's snowing. We're  gonna crash.");
            if (this.coordinates.getHeight() - 15 <= 0)
            {
                coordinates.setHeight(0);
                print("Baloon#" + name + "(" +id+ "):  landing.");
                weatherTower.unregister(this);
                print("Tower says: Baloon#" + name + "(" + id + "): unregistered from weather tower.");
                return;
            }
            else {
                coordinates.setHeight(coordinates.getHeight() - 15);
            }
        } else if (x.equals("SUN")) {
            print("Baloon#" + name + "(" +id+ "): Let's enjoy the good weather and take some pics.");
            if (this.coordinates.getHeight() + 4 >= 100)
            {
                coordinates.setHeight(100);
                print("JetPlane#" + name + "(" +id+ "): Cloud 9");
                return;
            }
            else
            {
                coordinates.setHeight(coordinates.getHeight() + 4);
            }
            coordinates.setLongitube(coordinates.getLongitube() + 2);
        }  else if (x.equals("RAIN")) {
            print("Baloon#" + name + "(" +id+ "): Damn you rain! You messed up my baloon.");
            if (this.coordinates.getHeight() - 5 <= 0)
            {
                coordinates.setHeight(0);
                print("Baloon#" + name + "(" +id+ "):  landing.");
                weatherTower.unregister(this);
                print("Tower says: Baloon#" + name + "(" + id + "): unregistered from weather tower. ");
                return;
            }
            else {
                coordinates.setHeight(coordinates.getHeight() - 5);
            }
        }  else if (x.equals("FOG")) {
            print("Baloon#" + name + "(" +id+ "): What the fog?");
            if (this.coordinates.getHeight() - 3 <= 0)
            {
                coordinates.setHeight(0);
                print("Baloon#" + name + "(" +id+ "):  landing.");
                weatherTower.unregister(this);
                print("Tower says: Baloon#" + name + "(" + id + "): unregistered from  weather tower.");

                return;
            }
            else {
                coordinates.setHeight(coordinates.getHeight() - 3);
            }
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        print("Tower says: Baloon#" + name + "(" + this.id + ") registered to weather tower");
        weatherTower.register(this);
    }
}