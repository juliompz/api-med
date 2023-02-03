package med.voll.api.medico.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DTOs.DadosEnderecoRecord;


public record AtualizarMedico(

        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String telefone,
        DadosEnderecoRecord endereco
) {
}
