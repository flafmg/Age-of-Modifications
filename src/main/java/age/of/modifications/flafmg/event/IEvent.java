package age.of.modifications.flafmg.event;

/**
 * Base interface for all events.
 */
public interface IEvent {
    /**
     * Returns the name of the event.
     */
    String getEventName();

    /**
     * Returns the timestamp of when the event was created.
     */
    long getTimestamp();

    /**
     * Sets the event cancelled state.
     */
    void cancel();

    /**
     * Returns if the event is cancelled.
     */
    boolean isCancelled();
}