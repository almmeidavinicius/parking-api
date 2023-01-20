package br.com.vinicius.parkingapi.controller;

import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping
    public ResponseEntity<Parking> create(@RequestBody Parking parking) {

        Parking createdParking = parkingService.create(parking);
        return ResponseEntity.ok(createdParking);
    }
}
