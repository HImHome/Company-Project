package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.VacationRequestDTO;
import com.rentzosc.company.project.entities.VacationRequest;
import com.rentzosc.company.project.repositories.VacationRequestRepository;
import jakarta.transaction.Transactional;
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

    private VacationRequestDTO convertToDto(VacationRequest vacationRequest) {
        return modelMapper.map(vacationRequest, VacationRequestDTO.class);
    }

    private VacationRequest convertToEntity(VacationRequestDTO vacationRequestDTO) {
        return modelMapper.map(vacationRequestDTO, VacationRequest.class);
    }

    @Transactional
    public VacationRequestDTO addVacationRequest(VacationRequestDTO vacationRequestDTO) {
        VacationRequest vacationRequest = convertToEntity(vacationRequestDTO);
        VacationRequest savedVacationRequest = vacationRequestRepository.save(vacationRequest);

        return convertToDto(savedVacationRequest);
    }

    @Transactional
    public VacationRequestDTO getVacationRequestById(Long requestId) {
        VacationRequest vacationRequest = vacationRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("VacationRequest with ID:" + requestId + " not found."));

        return convertToDto(vacationRequest);
    }

    @Transactional
    public List<VacationRequestDTO> getAllVacationRequests() {
        List<VacationRequest> vacationRequests = vacationRequestRepository.findAll();

        return vacationRequests.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteVacationRequest(Long requestId) {
        if (!vacationRequestRepository.existsById(requestId)) {
            throw new RuntimeException("VacationRequest with id: " + requestId + " not found.");
        }
        vacationRequestRepository.deleteById(requestId);
    }

    @Transactional
    public VacationRequestDTO updateVacationRequest(Long requestId, VacationRequestDTO vacationRequestDetails) {
        return vacationRequestRepository.findById(requestId).map(vacationRequest -> {
            modelMapper.map(vacationRequestDetails, vacationRequest);
            vacationRequest.setVacationRequestId(requestId);
            VacationRequest updatedVacationRequest = vacationRequestRepository.save(vacationRequest);

            return convertToDto(updatedVacationRequest);
        }).orElseThrow(() -> new RuntimeException("VacationRequest with id: " + requestId + " not found."));
    }
}