package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@CrossOrigin
public class TimeConverter {
    public static ArrayList<String> getTime() {
        ZonedDateTime time = ZonedDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        ZonedDateTime est = time.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime mst = time.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utc = time.withZoneSameInstant(ZoneId.of("UTC"));

        ArrayList<String> times = new ArrayList<>();
        times.add(est.format(timeFormat) + " EST");
        times.add(" " + mst.format(timeFormat) + " MST");
        times.add(" " + utc.format(timeFormat) + " UTC");

        return times;
    }
}
