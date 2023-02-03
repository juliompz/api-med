package med.voll.api.medico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DTOs.CadastroMedico;
import med.voll.api.medico.DTOs.AtualizarMedico;
import med.voll.api.medico.enums.EspecialidadeEnum;

import java.io.Serializable;


@Table(name = "medicos")

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Medico")
public class MedicoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private  String telefone;
    private String crm;
    private EspecialidadeEnum especialidade;
    private Endereco endereco;
    private Boolean ativo;

    public MedicoModel(@Valid CadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }

    public void atualizarInformacoes(AtualizarMedico dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }


        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
           this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
