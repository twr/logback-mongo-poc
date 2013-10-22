package twr.explore.logback;

public class Event {

    private final String id;

    private final long timestamp;

    private final Integer duration;

    public Event(String id, long timestamp) {
        this(id, timestamp, null);
    }

    public Event(String id, long timestamp, Integer duration) {
        this.id = id;
        this.timestamp = timestamp;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                (duration != null ? ", duration=" + duration : "") +
                '}';
    }

}
