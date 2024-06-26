package com.rentzosc.company.project.controllers;

import com.rentzosc.company.project.dtos.EmployeeDTO;
import com.rentzosc.company.project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
        EmployeeDTO savedEmployeeDto = employeeService.addEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDto);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employee) {
        EmployeeDTO updatedEmployeeDto = employeeService.updateEmployee(employeeId, employee);

        return ResponseEntity.ok(updatedEmployeeDto);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOs);
    }
}
