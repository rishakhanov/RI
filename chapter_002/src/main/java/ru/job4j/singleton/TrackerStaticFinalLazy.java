package ru.job4j.singleton;

//import javax.xml.ws.Holder;

public class TrackerStaticFinalLazy {
    private TrackerStaticFinalLazy() {
    }

    public static TrackerStaticFinalLazy getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerStaticFinalLazy INSTANCE = new TrackerStaticFinalLazy();
    }

    public static void main(String[] args) {
        TrackerStaticFinalLazy trackerStaticFinalLazy = TrackerStaticFinalLazy.getInstance();
    }
}
