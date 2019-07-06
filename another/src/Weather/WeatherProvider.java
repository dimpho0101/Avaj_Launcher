package Weather;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SNOW", "RAIN", "FOG", "SUN"};

    private WeatherProvider() {
        weatherProvider = this;
    }

    public static WeatherProvider getProvider() {
        new WeatherProvider();
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        //use a damn algorithm
        return weather[0];
    }
}
