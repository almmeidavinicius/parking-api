package br.com.vinicius.parkingapi.service;

import br.com.vinicius.parkingapi.dto.ParkingCreateDTO;
import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.exception.ParkingNotFoundException;
import br.com.vinicius.parkingapi.mapper.ParkingMapper;
import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;

    public ParkingDTO create(ParkingCreateDTO parkingCreateDTO) {

        Parking parkingToCreate = parkingMapper.toParking(parkingCreateDTO);
        parkingToCreate.setEntryDate(LocalDateTime.now());
        Parking createdParking = parkingRepository.save(parkingToCreate);
        return parkingMapper.toParkingDTO(createdParking);
    }

    public ParkingDTO findById(Long id) throws ParkingNotFoundException {

        Parking parking = checkIfExists(id);
        return parkingMapper.toParkingDTO(parking);
    }

    public List<ParkingDTO> findAll() {

        List<Parking> all = parkingRepository.findAll();
        return all.stream().map(parkingMapper::toParkingDTO).toList();
    }

    private Parking checkIfExists(Long id) throws ParkingNotFoundException {

        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }
}
