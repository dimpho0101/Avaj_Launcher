package aircraft;

public class Coordinates {
    private int longitube;
    private  int latitude;
    private  int height;

    public Coordinates(int longitube, int latitude, int height) {
        this.longitube = longitube;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitube() {
        return longitube;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitube(int longitube) {
        this.longitube = longitube;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
