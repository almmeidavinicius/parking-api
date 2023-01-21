package br.com.vinicius.parkingapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDTO {

    private Long id;

    @NotEmpty
    private String license;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String state;

    @NotEmpty
    private String model;

    @NotEmpty
    private String color;

    private LocalDateTime entryDate;

    private LocalDateTime departureDate;

    private Double bill;
}
