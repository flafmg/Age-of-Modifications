package age.of.modifications.flafmg.event;

import java.util.*;

/**
 * Manages the registration and dispatching of events.
 */
public class EventManager {
    private static final List<EventListener> listeners = new ArrayList<>();

    public static void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public static void dispatchEvent(Event event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

