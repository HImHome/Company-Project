package com.rentzosc.company.project.controllers;

import com.rentzosc.company.project.dtos.EmployeeProductJunctionDTO;
import com.rentzosc.company.project.services.EmployeeProductJunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-product-junctions")
public class EmployeeProductJunctionController {
    private final EmployeeProductJunctionService employeeProductJunctionService;

    @Autowired
    public EmployeeProductJunctionController(EmployeeProductJunctionService employeeProductJunctionService) {
        this.employeeProductJunctionService = employeeProductJunctionService;
    }

    @PostMapping
    public ResponseEntity<EmployeeProductJunctionDTO> addEmployeeProductJunction(@RequestBody EmployeeProductJunctionDTO employeeProductJunctionDTO) {
        EmployeeProductJunctionDTO savedJunction = employeeProductJunctionService.addEmployeeProductJunction(employeeProductJunctionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJunction);
    }

    @GetMapping("/{employeeProductJunctionId}")
    public ResponseEntity<EmployeeProductJunctionDTO> getEmployeeProductJunctionById(@PathVariable Long employeeProductJunctionId) {
        try {
            EmployeeProductJunctionDTO employeeProductJunctionDTO =
                    employeeProductJunctionService.getEmployeeProductJunctionById(employeeProductJunctionId);
            return ResponseEntity.ok(employeeProductJunctionDTO);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{employeeProductJunctionId}")
    public ResponseEntity<Void> deleteEmployeeProductJunction(@PathVariable Long employeeProductJunctionId) {
        try {
            employeeProductJunctionService.deleteEmployeeProductJunction(employeeProductJunctionId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{employeeProductJunctionId}")
    public ResponseEntity<EmployeeProductJunctionDTO> updateEmployeeProductJunction(@PathVariable Long employeeProductJunctionId, @RequestBody EmployeeProductJunctionDTO employeeProductJunctionDTO) {
        EmployeeProductJunctionDTO updatedEmployeeProductJunction =
                employeeProductJunctionService.updateEmployeeProductJunction(employeeProductJunctionId, employeeProductJunctionDTO );

        return ResponseEntity.ok(updatedEmployeeProductJunction);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProductJunctionDTO>> getAllEmployeeProductJunctions() {
        return ResponseEntity.ok(employeeProductJunctionService.getAllEmployeeProductJunctions());
    }
}
