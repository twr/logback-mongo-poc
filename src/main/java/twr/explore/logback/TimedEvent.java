package twr.explore.logback;

public abstract class TimedEvent {

    private final String id;

    protected TimedEvent(String id) {
        this.id = id;
    }

    public abstract void execute() throws Exception;

    public String getId() {
        return id;
    }

}
