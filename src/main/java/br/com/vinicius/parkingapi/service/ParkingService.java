package br.com.vinicius.parkingapi.service;

import br.com.vinicius.parkingapi.dto.ParkingCreateDTO;
import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.mapper.ParkingMapper;
import br.com.vinicius.parkingapi.model.Parking;
import br.com.vinicius.parkingapi.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public ParkingDTO findById(Long id) {

        Optional<Parking> optionalParking = parkingRepository.findById(id);
        if (!optionalParking.isEmpty()) return parkingMapper.toParkingDTO(optionalParking.get());
        return null;
    }

    public List<ParkingDTO> findAll() {

        List<Parking> all = parkingRepository.findAll();
        return all.stream()
                .map(parkingMapper::toParkingDTO)
                .toList();
    }
}
