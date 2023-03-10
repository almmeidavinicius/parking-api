package br.com.vinicius.parkingapi.controller;

import br.com.vinicius.parkingapi.dto.ParkingCreateDTO;
import br.com.vinicius.parkingapi.dto.ParkingDTO;
import br.com.vinicius.parkingapi.exception.ParkingNotFoundException;
import br.com.vinicius.parkingapi.service.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Parking endpoint")
@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Create a new parking record")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ParkingDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody @Valid ParkingCreateDTO parkingCreateDTO) {

        ParkingDTO createdParking = parkingService.create(parkingCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParking);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(summary = "Find a parking by your id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ParkingDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id) throws ParkingNotFoundException {

        ParkingDTO parkingDTO = parkingService.findById(id);
        return ResponseEntity.ok(parkingDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Calculates the bill to be paid in the parking")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable Long id) throws ParkingNotFoundException {

        ParkingDTO parkingDTO = parkingService.checkOut(id);
        return ResponseEntity.ok(parkingDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(summary = "List all registered parking lots")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ParkingDTO.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(HttpServletRequest request) {

        List<ParkingDTO> parkingDTOList = parkingService.findAll();
        return ResponseEntity.ok(parkingDTOList);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete a parking by your id")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No Content", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws ParkingNotFoundException {

        parkingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(summary = "Update parking information")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable Long id, @RequestBody ParkingCreateDTO parkingToUpdateDTO) throws ParkingNotFoundException {

        ParkingDTO updatedParking = parkingService.update(id, parkingToUpdateDTO);
        return ResponseEntity.ok(updatedParking);
    }
}