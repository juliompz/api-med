package med.voll.api.medico.DTOs;

import med.voll.api.medico.enums.EspecialidadeEnum;
import med.voll.api.medico.MedicoModel;

public record ListagemMedico(Long id, String nome, String email , String crm, EspecialidadeEnum especialidade) {

    public ListagemMedico(MedicoModel medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
