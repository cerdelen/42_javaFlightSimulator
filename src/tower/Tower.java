package tower;

import java.util.ArrayList;
import java.util.List;

import aircraft.*;
import interfaces.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
            System.out.println("Tower says: " + ((Aircraft) p_flyable).getHandle()  + " registered to weather tower.");
        }
    }

    public void unregister(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            System.out.println("Tower says: " + ((Aircraft) p_flyable).getHandle() + " unregistered from weather tower.");
        }
    }

    public void conditionChanged() {
        for (Flyable flyable : new ArrayList<>(observers)) {
            flyable.updateConditions();
        }
    }
}
