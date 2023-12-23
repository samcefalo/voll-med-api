package med.voll.api.dto;

import med.voll.api.entity.Especialidade;
import med.voll.api.entity.MedicoEntity;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(MedicoEntity entity) {
        this(entity.getId(), entity.getNome(), entity.getEmail(), entity.getCrm(), entity.getEspecialidade());
    }
}
