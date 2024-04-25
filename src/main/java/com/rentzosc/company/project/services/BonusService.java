package com.rentzosc.company.project.services;

import com.rentzosc.company.project.dtos.BonusDTO;
import com.rentzosc.company.project.entities.Bonus;
import com.rentzosc.company.project.repositories.BonusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusService {
    private final BonusRepository bonusRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BonusService(BonusRepository bonusRepository, ModelMapper modelMapper) {
        this.bonusRepository = bonusRepository;
        this.modelMapper = modelMapper;
    }

    private BonusDTO convertBonusToDto (Bonus bonus) {
        return modelMapper.map(bonus, BonusDTO.class);
    }

    private Bonus converDtoToBonus (BonusDTO bonusDTO) {
        return modelMapper.map(bonusDTO, Bonus.class);
    }

    private BonusDTO addBonus (BonusDTO bonusDTO) {
        Bonus bonus = converDtoToBonus(bonusDTO);
        Bonus savedBonus = bonusRepository.save(bonus);

        return convertBonusToDto(savedBonus);
    }

    private BonusDTO getBonusById(Long bonusId) {
        Bonus bonus = bonusRepository.findById(bonusId).orElseThrow(() -> new RuntimeException("Bonus with ID: " + bonusId + " not found."));

        return convertBonusToDto(bonus);
    }

    public List<BonusDTO> getAllBonuses() {
        List<Bonus> bonus = bonusRepository.findAll();

        return bonus.stream().map(this::convertBonusToDto).collect(Collectors.toList());
    }

    public void deleteBonus(Long bonusId) {
        if(!bonusRepository.existsById(bonusId)){
            throw new RuntimeException("Bonus with ID: " + bonusId + " not found.");
        }

        bonusRepository.deleteById(bonusId);
    }

    public BonusDTO updateBonus(Long bonusId, BonusDTO bonusDTO) {
        Bonus bonus = bonusRepository.findById(bonusId).orElseThrow(() -> new RuntimeException("Bonus with ID: " + bonusId + " not found."));

        modelMapper.map(bonusDTO, bonus);
        Bonus updatedBonus = bonusRepository.save(bonus);

        return convertBonusToDto(updatedBonus);
    }
}
