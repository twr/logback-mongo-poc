package twr.explore.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.mongodb.MongoDBAppenderBase;
import com.mongodb.BasicDBObject;

import java.util.Date;

public class MongoDBMetricsAppender extends MongoDBAppenderBase<ILoggingEvent> {

    @Override
    protected BasicDBObject toMongoDocument(ILoggingEvent loggingEvent) {
        BasicDBObject logEntry = new BasicDBObject();
        if (loggingEvent.getArgumentArray() != null && loggingEvent.getArgumentArray().length == 1) {
            Object o = loggingEvent.getArgumentArray()[0];
            if (o instanceof Event) {
                Event event = ((Event) o);
                logEntry.append("timestamp", new Date(event.getTimestamp()));
                logEntry.append("id", event.getId());
                if (event.getDuration() != null) {
                    logEntry.append("duration", event.getDuration());
                }
            }
        }
        return logEntry;
    }

}
