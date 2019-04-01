package ru.job4j.singleton;

//import ru.job4j.tracker.Tracker;

public class TrackerStaticLazy {
    private static TrackerStaticLazy instance;

    private TrackerStaticLazy() {
    }

    public static TrackerStaticLazy getInstance() {
        if (instance == null) {
            instance = new TrackerStaticLazy();
        }
        return instance;
    }
}
