package Weather;

import aircraft.Flyable;

import java.util.ArrayList;

public abstract class Tower {

    private ArrayList<Flyable> observers;

    public Tower()
    {
        observers = new ArrayList<>();
    }
    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int c = 0; c < observers.size(); c++)
        {
            observers.get(c).updateConditions();
        }
    }
}
