package aircraft;

import Weather.WeatherTower;

import static Weather.Logger.print;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String x = weatherTower.getWeather(coordinates);

        if (x.equals("SNOW")) {
            print("JetPlane#" + name + "(" +id+ "): OMG! Winter is coming!");
            if (this.coordinates.getHeight() - 7 <= 0)
            {
                coordinates.setHeight(0);
                print("JetPlane#" + name + "(" +id+ "):  landing.");
                weatherTower.unregister(this);
                print("Tower says: JetPlane#" + name + "(" + id + "): unregistered from weather tower.");
                return;
            } else {
                coordinates.setHeight(coordinates.getHeight() - 7);
            }
        } else if (x.equals("SUN")) {
            print("JetPlane#" + name + "(" +id+ "): The sun");
            if (this.coordinates.getHeight() + 2 <= 100)
            {
                coordinates.setHeight(100);
                print("JetPlane#" + name + "(" +id+ "): Cloud 9");
                print("Tower says: JetPlaner#" + name + "(" + id + "): unregistered from weather tower.");
                weatherTower.unregister(this);
                return;
            } else {
                coordinates.setHeight(coordinates.getHeight() + 2);
            }
            coordinates.setLatitude(coordinates.getLatitude() + 10);
        }  else if (x.equals("RAINS")) {
            print("JetPlane#" + name + "(" +id+ "):  It's raining. Better watch out for lightings");
            coordinates.setLatitude(coordinates.getLatitude() + 5);
        }  else if (x.equals("FOG")) {
            print("JetPlane#" + name + "(" +id+ "): fog");
            coordinates.setLatitude(coordinates.getLatitude() + 1);
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        print("Tower says: JetPlane#" + name + "(" + this.id + ") registered to weather tower");
        weatherTower.register(this);
    }
}