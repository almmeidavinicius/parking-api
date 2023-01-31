package br.com.vinicius.parkingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends Exception {
    public ParkingNotFoundException(Long id) {
        super("Not found parking with id = " + id);
    }
}
