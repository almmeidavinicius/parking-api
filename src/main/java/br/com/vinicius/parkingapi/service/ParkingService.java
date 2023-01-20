package br.com.vinicius.parkingapi.service;

import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.mapper.ParkingMapper;
import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;

    public ParkingDTO create(ParkingDTO parkingDTO) {

        Parking parkingToCreate = parkingMapper.toParking(parkingDTO);
        Parking createdParking = parkingRepository.save(parkingToCreate);
        return parkingMapper.toParkingDTO(createdParking);
    }
}
