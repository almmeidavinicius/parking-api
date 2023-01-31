package br.com.vinicius.parkingapi.mapper;

import br.com.vinicius.parkingapi.dto.ParkingCreateDTO;
import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Parking toParking(ParkingDTO parkingDTO) {
        return MODEL_MAPPER.map(parkingDTO, Parking.class);
    }

    public Parking toParking(ParkingCreateDTO parkingCreateDTO) {
        return MODEL_MAPPER.map(parkingCreateDTO, Parking.class);
    }

    public ParkingDTO toParkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

}
