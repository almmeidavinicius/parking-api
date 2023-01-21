package br.com.vinicius.parkingapi.controller;

import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingDTO parkingDTO) {

        ParkingDTO createdParking = parkingService.create(parkingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id) {

        ParkingDTO parkingDTO = parkingService.findById(id);
        return ResponseEntity.ok(parkingDTO);
    }
}
