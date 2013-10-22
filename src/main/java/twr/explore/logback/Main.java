package twr.explore.logback;

public class Main {

    public static void main(String[] args) throws Exception {
        // manual
        long start = System.currentTimeMillis();
        timedEvent();
        long end = System.currentTimeMillis();

        int duration = Long.valueOf(end - start).intValue();

        Metrics.log(new Event("GET /users/accounts", start, duration));

        // just log the occurrence not duration
        Metrics.log(new Event("GET /users/accounts", start));

        // wrap around the timed event
        Metrics.log(new TimedEvent("GET /fields/jobTitles") {
            public void execute() throws Exception {
                timedEvent();
            }
        });
    }

    private static void timedEvent() throws InterruptedException {
        Thread.sleep(100);
    }

}
