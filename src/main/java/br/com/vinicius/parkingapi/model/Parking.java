package br.com.vinicius.parkingapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String license;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column
    @JsonFormat(pattern = "dd-MM-yyy")
    private LocalDateTime entryDate;

    @Column
    @JsonFormat(pattern = "dd-MM-yyy")
    private LocalDateTime departureDate;

    @Column
    private Double bill;

}
