package med.voll.api.medico;

import jakarta.validation.Valid;
import med.voll.api.medico.DTOs.CadastroMedico;
import med.voll.api.medico.DTOs.ListagemMedico;
import med.voll.api.medico.DTOs.AtualizarMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicorepository;

    @PostMapping
    @Transactional
    public void Cadastrar(@RequestBody @Valid CadastroMedico dados) {
        medicorepository.save(new MedicoModel(dados));
    }

    @GetMapping
    public Page<ListagemMedico> Listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicorepository.findAllByAtivoTrue(paginacao).map(ListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedico dados) {
        var medico = medicorepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

        /*@DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        medicorepository.deleteById(id);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = medicorepository.getReferenceById(id);
        medico.excluir();

    }
}

