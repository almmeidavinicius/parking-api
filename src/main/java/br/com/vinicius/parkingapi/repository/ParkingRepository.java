package br.com.vinicius.parkingapi.repository;

import br.com.vinicius.parkingapi.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
