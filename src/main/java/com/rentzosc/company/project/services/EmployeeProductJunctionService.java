package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.EmployeeProductJunctionDTO;
import com.rentzosc.company.project.entities.EmployeeProductJunction;
import com.rentzosc.company.project.repositories.EmployeeProductJunctionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeProductJunctionService {
    private final EmployeeProductJunctionRepository employeeProductJunctionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeProductJunctionService(EmployeeProductJunctionRepository employeeProductJunctionRepository, ModelMapper modelMapper) {
        this.employeeProductJunctionRepository = employeeProductJunctionRepository;
        this.modelMapper = modelMapper;
    }

    private EmployeeProductJunctionDTO convertEmployeeProductJunctionToDto(EmployeeProductJunction employeeProductJunction) {
        return modelMapper.map(employeeProductJunction, EmployeeProductJunctionDTO.class);
    }

    private EmployeeProductJunction convertDtoEmPloyeeProductJunction(EmployeeProductJunctionDTO employeeProductJunctionDTO) {
        return modelMapper.map(employeeProductJunctionDTO, EmployeeProductJunction.class);
    }

    public EmployeeProductJunctionDTO addEmployeeProductJunction(EmployeeProductJunctionDTO employeeProductJunctionDTO) {
        EmployeeProductJunction employeeProductJunction = convertDtoEmPloyeeProductJunction(employeeProductJunctionDTO);
        EmployeeProductJunction savedEmployeeProductJunction = employeeProductJunctionRepository.save(employeeProductJunction);

        return convertEmployeeProductJunctionToDto(savedEmployeeProductJunction);
    }

    public EmployeeProductJunctionDTO getEmployeeProductJunctionById(Long employeeProductJunctionId) {
        EmployeeProductJunction employeeProductJunction = employeeProductJunctionRepository.findById(employeeProductJunctionId).orElseThrow(() -> new RuntimeException("EmployeeProductJunction with ID: " + employeeProductJunctionId + " not found."));

        return convertEmployeeProductJunctionToDto(employeeProductJunction);
    }

    public List<EmployeeProductJunctionDTO> getAllEmployeeProductJunctions() {
        List<EmployeeProductJunction> employeeProductJunctions = employeeProductJunctionRepository.findAll();

        return employeeProductJunctions.stream().map(this::convertEmployeeProductJunctionToDto).collect(Collectors.toList());
    }

    public void deleteEmployeeProductJunction(Long employeeProductJunctionId) {
        if (!employeeProductJunctionRepository.existsById(employeeProductJunctionId)) {
            throw new RuntimeException("EmployeeProductJunction with ID:" + employeeProductJunctionId + " does not " + "exist");
        }

        employeeProductJunctionRepository.deleteById(employeeProductJunctionId);
    }

    public EmployeeProductJunctionDTO updateEmployeeProductJunction(Long employeeProductJunctionId,
                                                                    EmployeeProductJunctionDTO employeeProductJunctionDetails) {
        return employeeProductJunctionRepository.findById(employeeProductJunctionId).map(employeeProductJunction -> {
            modelMapper.map(employeeProductJunctionDetails, employeeProductJunction);
            employeeProductJunction.setEmployeeProductJunctionId(employeeProductJunctionId);
            EmployeeProductJunction updatedEmployeeProductJunction =
                    employeeProductJunctionRepository.save(employeeProductJunction);

            return modelMapper.map(updatedEmployeeProductJunction, EmployeeProductJunctionDTO.class);
        }).orElseThrow(() -> new RuntimeException("EmployeeProductJunction with id: " + employeeProductJunctionId +
                " not found."));
    }
}
