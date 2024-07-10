package age.of.modifications.flafmg.event;

public abstract class Event implements IEvent {
    private final String eventName;
    private final long timestampMillis;
    private boolean cancelled;

    public Event(String eventName) {
        this.eventName = eventName;
        this.timestampMillis = System.currentTimeMillis();
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public long getTimestamp() {
        return timestampMillis;
    }

    @Override
    public void cancel() {
        cancelled = true;
    }

    @Override
    public boolean isCancelled(){
        return cancelled;
    }
}
