package ru.job4j.singleton;

public class TrackerStaticFinalEager {
    private static final TrackerStaticFinalEager INSTANCE = new TrackerStaticFinalEager();

    private TrackerStaticFinalEager() {
    }

    public static TrackerStaticFinalEager getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerStaticFinalEager trackerStaticFinalEager = TrackerStaticFinalEager.getInstance();
    }
}
