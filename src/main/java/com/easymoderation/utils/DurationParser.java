package com.easymoderation.utils;

import java.util.concurrent.TimeUnit;

public class DurationParser {
    public static long parseDuration(String duration) {
        String numbers = duration.replaceAll("[^0-9]", "");
        String unit = duration.replaceAll("[^a-zA-Z]", "");
        
        if (numbers.isEmpty() || unit.isEmpty()) {
            throw new IllegalArgumentException("Invalid duration format");
        }

        long time = Long.parseLong(numbers);
        switch (unit.toLowerCase()) {
            case "d":
                return TimeUnit.DAYS.toMillis(time);
            case "h":
                return TimeUnit.HOURS.toMillis(time);
            case "m":
                return TimeUnit.MINUTES.toMillis(time);
            case "s":
                return TimeUnit.SECONDS.toMillis(time);
            default:
                throw new IllegalArgumentException("Invalid time unit");
        }
    }
} 