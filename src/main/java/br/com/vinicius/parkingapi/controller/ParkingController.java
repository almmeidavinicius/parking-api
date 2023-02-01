package br.com.vinicius.parkingapi.controller;

import br.com.vinicius.parkingapi.dto.ParkingCreateDTO;
import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.exception.ParkingNotFoundException;
import br.com.vinicius.parkingapi.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingCreateDTO) {

        ParkingDTO createdParking = parkingService.create(parkingCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParking);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable Long id) throws ParkingNotFoundException {
        ParkingDTO parkingDTO = parkingService.checkOut(id);
        return ResponseEntity.ok(parkingDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id) throws ParkingNotFoundException {

        ParkingDTO parkingDTO = parkingService.findById(id);
        return ResponseEntity.ok(parkingDTO);
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll() {

        List<ParkingDTO> parkingDTOList = parkingService.findAll();
        return ResponseEntity.ok(parkingDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws ParkingNotFoundException {

        parkingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable Long id, @RequestBody ParkingCreateDTO parkingToUpdateDTO) throws ParkingNotFoundException {

        ParkingDTO updatedParking = parkingService.update(id, parkingToUpdateDTO);
        return ResponseEntity.ok(updatedParking);
    }
}
