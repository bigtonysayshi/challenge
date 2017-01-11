package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity),
 * return true if the message should be printed in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter {
    public static void main(String[] args){
        Logger instance = new Logger();
        System.out.println(instance.shouldPrintMessage(1, "foo"));
        System.out.println(instance.shouldPrintMessage(2, "bar"));
        System.out.println(instance.shouldPrintMessage(3, "foo"));
        System.out.println(instance.shouldPrintMessage(8, "bar"));
        System.out.println(instance.shouldPrintMessage(10, "foo"));
        System.out.println(instance.shouldPrintMessage(11, "foo"));
    }
}

class Logger {
    private final Map<String, Integer> messageMap;

    /** Initialize your data structure here. */
    public Logger() {
        messageMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer prevTimestamp = messageMap.get(message);
        if (prevTimestamp == null || timestamp - prevTimestamp >= 10) {
            messageMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}
