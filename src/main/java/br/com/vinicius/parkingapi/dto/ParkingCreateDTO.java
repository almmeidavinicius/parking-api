package br.com.vinicius.parkingapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingCreateDTO {

    @NotEmpty
    private String license;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String state;

    @NotEmpty
    private String model;

    @NotEmpty
    private String color;
}
