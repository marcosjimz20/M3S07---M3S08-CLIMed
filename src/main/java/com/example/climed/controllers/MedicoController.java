package com.example.climed.controllers;

import com.example.climed.dtos.MedicoDto;
import com.example.climed.entidades.MedicoEntity;
import com.example.climed.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;


// Endpoints
    @PostMapping("new-medico")
    public ResponseEntity<MedicoEntity> saveMedico(@RequestBody @Valid MedicoDto medicoDto) {
        var medicoEntity = new MedicoEntity();

        BeanUtils.copyProperties(medicoDto, medicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoEntity));
    }

    @GetMapping("list-medicos")
    public ResponseEntity<List<MedicoDto>> getAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll().stream().map(MedicoDto::new).toList());
    }

    @PutMapping("medico/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value="id") UUID id, @RequestBody @Valid MedicoDto medicoDto){
        Optional<MedicoEntity> medicoOpt = medicoRepository.findById(id);
        if(medicoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }

        var medicoEntity = medicoOpt.get();
        BeanUtils.copyProperties(medicoDto, medicoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoEntity));
    }

    @DeleteMapping("medico/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value="id") UUID id) {
        Optional<MedicoEntity> medicoOpt = medicoRepository.findById(id);
        if(medicoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }
        medicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medico deleted successfully.");
    }
}
