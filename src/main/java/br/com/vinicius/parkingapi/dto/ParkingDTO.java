package br.com.vinicius.parkingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDTO {

    private Long id;

    private String license;

    private String state;

    private String model;

    private String color;

    private java.time.LocalDateTime entryDate;

    private java.time.LocalDateTime departureDate;

    private Double bill;
}
