package com.example.climed.dtos;

import com.example.climed.entidades.MedicoEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record MedicoDto(
        @NotEmpty(message = "O campo Nome é obrigatorio.")
        String nome,
        @NotBlank(message = "O campo E-mail é obrigatorio.")
        @Email(message = "O campo E-mail deve ser um endereço de e-mail valido.")
        String email,
        @NotBlank(message = "O campo Telefone é obrigatorio.")
        @Size(min=16, max=16)
        String telefone,
        @NotEmpty(message = "O campo CRM é obrigatorio.")
        String crm

) {
    public MedicoDto(MedicoEntity medico) {
        this(medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm());
    }

}
