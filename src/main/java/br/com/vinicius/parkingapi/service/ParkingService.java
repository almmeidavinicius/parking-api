package br.com.vinicius.parkingapi.service;

import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.mapper.ParkingMapper;
import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ParkingDTO findById(Long id) {

        Optional<Parking> optionalParking = parkingRepository.findById(id);
        if (!optionalParking.isEmpty()) return parkingMapper.toParkingDTO(optionalParking.get());
        return null;
    }
}
