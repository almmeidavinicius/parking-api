package br.com.vinicius.parkingapi.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CheckoutService {

    public static Double getBill(LocalDateTime entryDate, LocalDateTime departureDate) {

        long minutes = entryDate.until(departureDate, ChronoUnit.MINUTES);
        Double bill = 0d;
        if (minutes <= 60d) {
            bill = 20d;
            return bill;
        } else {
            bill = 20d + (minutes - 60) * 0.25d;
            return bill;
        }
    }
}
