package br.com.vinicius.parkingapi.service;

import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public Parking create(Parking parking) {

        Parking createdParking = parkingRepository.save(parking);
        return createdParking;
    }
}
