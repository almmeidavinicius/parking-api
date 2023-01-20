package br.com.vinicius.parkingapi.repository;

import br.com.vinicius.parkingapi.model.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {
}
