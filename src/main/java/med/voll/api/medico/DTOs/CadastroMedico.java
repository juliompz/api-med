package med.voll.api.medico.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DTOs.DadosEnderecoRecord;
import med.voll.api.medico.enums.EspecialidadeEnum;

public record CadastroMedico(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeEnum especialidade,
        @NotNull
        @Valid
        DadosEnderecoRecord endereco) {
}
