package com.rentzosc.company.project.controllers;

import com.rentzosc.company.project.dtos.VacationRequestDTO;
import com.rentzosc.company.project.services.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacation-requests")
public class VacationRequestController {
    private final VacationRequestService vacationRequestService;


    @Autowired
    public VacationRequestController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }

    @PostMapping
    public ResponseEntity<VacationRequestDTO> addVacationRequest(@RequestBody VacationRequestDTO vacationRequestDTO) {
        VacationRequestDTO savedVacationRequestDTO = vacationRequestService.addVacationRequest(vacationRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedVacationRequestDTO);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<VacationRequestDTO> getVacationRequestById(@PathVariable Long requestId) {
        try {
            VacationRequestDTO vacationRequestDTO = vacationRequestService.getVacationRequestById(requestId);

            return ResponseEntity.ok(vacationRequestDTO);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteVacationRequest(@PathVariable Long requestId) {
        try {
            vacationRequestService.deleteVacationRequest(requestId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{requestId}")
    public ResponseEntity<VacationRequestDTO> updateVacationRequest(@PathVariable Long requestId, @RequestBody VacationRequestDTO vacationRequestDTO) {
        VacationRequestDTO updatedVacationRequestDTO = vacationRequestService.updateVacationRequest(requestId, vacationRequestDTO);

        return ResponseEntity.ok(updatedVacationRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<VacationRequestDTO>> getAllVacationRequests() {
        List<VacationRequestDTO> vacationRequestDTOs = vacationRequestService.getAllVacationRequests();

        return ResponseEntity.ok(vacationRequestDTOs);
    }
}