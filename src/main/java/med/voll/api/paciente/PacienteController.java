package med.voll.api.paciente;

import jakarta.validation.Valid;
import med.voll.api.paciente.DTOs.AtualizarPaciente;
import med.voll.api.paciente.DTOs.ListagemPaciente;
import med.voll.api.paciente.DTOs.CadastroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienterepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroPaciente dados){

        pacienterepository.save(new PacienteModel(dados));
    }

    @GetMapping
    public Page<ListagemPaciente> Listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienterepository.findAllByAtivoTrue(paginacao).map(ListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarPaciente dados){
        var paciente = pacienterepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = pacienterepository.getReferenceById(id);
        paciente.excluir();
    }
}
