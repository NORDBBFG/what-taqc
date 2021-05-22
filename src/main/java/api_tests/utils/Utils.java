package api_tests.utils;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static String getCurrentDateTime() {
        return LocalDate.now().atTime(0, 0).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }


    @SneakyThrows
    public static String getCalculateDateByMethod(DateTimeMethods method, long units) {
        LocalDateTime localDateTime = (LocalDateTime) LocalDateTime.class.getDeclaredMethod(method.getGetMethod(), long.class).invoke(LocalDate.now().atTime(0, 0), units);
        return localDateTime.format(formatter);
    }
}
