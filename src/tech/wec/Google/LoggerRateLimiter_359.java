package tech.wec.Google;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_359 {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
    }

    static class Logger {

        // key for log, value for timestamp
        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public Logger() {
            map = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message) && (map.get(message)+10) > timestamp){
                return false;
            }else{
                map.put(message, timestamp);
                return true;
            }
        }
    }
}
