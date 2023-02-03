package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.DTOs.AtualizarPaciente;
import med.voll.api.paciente.DTOs.CadastroPaciente;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Endereco endereco;
    private Boolean ativo;

    public PacienteModel(CadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = dados.endereco();
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizarPaciente dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
