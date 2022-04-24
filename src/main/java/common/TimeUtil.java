package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    // Get current system time by below format, eg: dateTimeFormat = "yyyy_MM_dd-HH_mm_ss"
    public static String getSystemTimeHMS(String dateTimeFormat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateTimeFormat);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
