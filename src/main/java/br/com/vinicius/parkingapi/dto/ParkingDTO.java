package br.com.vinicius.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

    private Long id;

    private String license;

    private String state;

    private String model;

    private String color;

    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private LocalDateTime entryDate;

    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private LocalDateTime departureDate;

    private Double bill;
}
