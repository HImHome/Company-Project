package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.VacationRequestDTO;
import com.rentzosc.company.project.entities.VacationRequest;
import com.rentzosc.company.project.repositories.VacationRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationRequestService {
    private final VacationRequestRepository vacationRequestRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public VacationRequestService(VacationRequestRepository vacationRequestRepository, ModelMapper modelMapper) {
        this.vacationRequestRepository = vacationRequestRepository;
        this.modelMapper = modelMapper;
    }

    private VacationRequestDTO convertVacationRequestToDto(VacationRequest vacationRequest) {
        return modelMapper.map(vacationRequest, VacationRequestDTO.class);
    }

    private VacationRequest convertDtoToVacationRequest(VacationRequestDTO vacationRequestDTO) {
        return modelMapper.map(vacationRequestDTO, VacationRequest.class);
    }

    public VacationRequestDTO createVacationRequest(VacationRequestDTO vacationRequestDTO) {
        VacationRequest vacationRequest = convertDtoToVacationRequest(vacationRequestDTO);
        VacationRequest savedVacationRequest = vacationRequestRepository.save(vacationRequest);

        return convertVacationRequestToDto(savedVacationRequest);
    }

    public VacationRequestDTO getVacationRequestById(Long vacationRequestId) {
        VacationRequest vacationRequest =
                vacationRequestRepository.findById(vacationRequestId).orElseThrow(() -> new RuntimeException("The " +
                        "request with ID:" + vacationRequestId + " does not exist."));

        return convertVacationRequestToDto(vacationRequest);
    }

    public List<VacationRequestDTO> getAllVacationRequests() {
        List<VacationRequest> vacationRequests = vacationRequestRepository.findAll();

        return vacationRequests.stream().map(this::convertVacationRequestToDto).collect(Collectors.toList());
    }

    public void deleteVacationRequest(Long vacationRequestId) {
        if(!vacationRequestRepository.existsById(vacationRequestId)) {
            throw new RuntimeException("The " +
                    "request with ID:" + vacationRequestId + " does not exist.");
        }

        vacationRequestRepository.deleteById(vacationRequestId);
    }

    public VacationRequestDTO updateVacationRequest(Long vacationRequestId, VacationRequestDTO vacationRequestDTO) {
        VacationRequest vacationRequest =
                vacationRequestRepository.findById(vacationRequestId).orElseThrow(() -> new RuntimeException("The " +
                "request with ID:" + vacationRequestId + " does not exist."));

        modelMapper.map(vacationRequestDTO, vacationRequest);
        VacationRequest updatedVacationRequest = vacationRequestRepository.save(vacationRequest);

        return convertVacationRequestToDto(updatedVacationRequest);
    }
}


