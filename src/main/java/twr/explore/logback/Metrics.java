package twr.explore.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Metrics {

    private static final Logger METRICS_LOGGER = LoggerFactory.getLogger("MONGO");

    public static void log(TimedEvent event) throws Exception {
        long start = System.currentTimeMillis();
        event.execute();
        long end = System.currentTimeMillis();

        int duration = Long.valueOf(end - start).intValue();

        METRICS_LOGGER.info("{}", new Event(event.getId(), start, duration));
    }

    public static void log(Event event) {
        METRICS_LOGGER.info("{}", event);
    }

}
