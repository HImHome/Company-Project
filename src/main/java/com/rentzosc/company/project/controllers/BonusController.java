package com.rentzosc.company.project.controllers;

import com.rentzosc.company.project.dtos.BonusDTO;
import com.rentzosc.company.project.entities.Bonus;
import com.rentzosc.company.project.services.BonusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonuses")
public class BonusController {
    private final BonusService bonusService;
    private final ModelMapper modelMapper;

    @Autowired
    public BonusController(BonusService bonusService, ModelMapper modelMapper) {
        this.bonusService = bonusService;
        this.modelMapper = modelMapper;
    }

    private BonusDTO convertBonusToDto(Bonus bonus) {
        return modelMapper.map(bonus, BonusDTO.class);
    }

    private Bonus convertDtoToBonus(BonusDTO bonusDTO) {
        return modelMapper.map(bonusDTO, Bonus.class);
    }

    @PostMapping
    public ResponseEntity<BonusDTO> addBonus(@RequestBody BonusDTO bonusDTO) {
        return ResponseEntity.ok(bonusService.addBonus(bonusDTO));
    }

    @GetMapping("/{bonusId}")
    public ResponseEntity<BonusDTO> getBonusById(@PathVariable Long bonusId) {
        return ResponseEntity.ok(bonusService.getBonusById(bonusId));
    }

    @DeleteMapping("/{bonusId}")
    public ResponseEntity<Void> deleteBonus(@PathVariable Long bonusId) {
        try {
            bonusService.deleteBonus(bonusId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{bonusId}")
    public ResponseEntity<BonusDTO> updateBonus(@PathVariable Long bonusId, @RequestBody BonusDTO bonusDTO) {
        Bonus bonus = convertDtoToBonus(bonusDTO);
        BonusDTO updatedBonus = bonusService.updateBonus(bonusId, bonus);
        return ResponseEntity.ok(updatedBonus);
    }

    @GetMapping
    public ResponseEntity<List<BonusDTO>> getAllBonuses() {
        return ResponseEntity.ok(bonusService.getAllBonuses());
    }
}