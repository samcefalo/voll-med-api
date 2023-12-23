package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizacaoMedico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosListagemMedico;
import med.voll.api.entity.MedicoEntity;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static med.voll.api.util.ApplicationConstants.API_MEDICOS_PATH;

@RestController
@RequestMapping(API_MEDICOS_PATH)
public class MedicoController {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public void cadastrar(@Valid @RequestBody DadosCadastroMedico dadosCadastroMedico) {
        MedicoEntity medicoEntity = new MedicoEntity(dadosCadastroMedico);
        medicoRepository.save(medicoEntity);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByEnableTrue(pageable).map(DadosListagemMedico::new);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);
        medicoEntity.atualizar(dadosAtualizacaoMedico);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable Long id) {
        MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);
        medicoEntity.setEnable(false);
    }

}
