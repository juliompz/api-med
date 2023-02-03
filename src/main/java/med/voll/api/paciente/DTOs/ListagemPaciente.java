package med.voll.api.paciente.DTOs;

import med.voll.api.paciente.PacienteModel;

public record ListagemPaciente(Long id, String nome, String email, String cpf) {

    public ListagemPaciente(PacienteModel paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
