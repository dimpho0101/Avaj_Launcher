package Weather;

import aircraft.Coordinates;

public class WeatherTower extends Tower{
    private Coordinates coordinates;
    private String weather = "";

    public String getWeather(Coordinates coordinates) {
        this.coordinates = coordinates;
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        weather = weatherProvider.getCurrentWeather(coordinates);
        return weather;
    }

    void changeWeather() {
        if (weather.equals("SNOW"))
        {
            weather = "SUN";
        }
        else if (weather.equals("RAIN"))
        {
            weather = "FOG";
        }
        else if (weather.equals("FOG"))
        {
            weather = "SNOW";
        }
        else if (weather.equals("SUN"))
        {
            weather = "RAIN";
        }
        conditionsChanged();
    }
}
