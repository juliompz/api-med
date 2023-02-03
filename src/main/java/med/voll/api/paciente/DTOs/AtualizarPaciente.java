package med.voll.api.paciente.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DTOs.DadosEnderecoRecord;

public record AtualizarPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        @Email
        String email,
        DadosEnderecoRecord endereco
){}
