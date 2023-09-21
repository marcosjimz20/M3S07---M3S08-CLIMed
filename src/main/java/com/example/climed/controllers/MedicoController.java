package com.example.climed.controllers;

import com.example.climed.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;


// Endpoints

}
