package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.DadosAtualizacaoMedico;
import med.voll.api.dto.DadosCadastroMedico;

import java.util.Objects;

import static java.util.Objects.nonNull;

@Entity
@Table(name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private EnderecoEntity endereco;
    private boolean enable = true;

    public MedicoEntity(DadosCadastroMedico dadosCadastroMedico) {
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.telefone = dadosCadastroMedico.telefone();
        this.crm = dadosCadastroMedico.crm();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.endereco = new EnderecoEntity(dadosCadastroMedico.endereco());
    }

    public void atualizar(DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        if (nonNull(dadosAtualizacaoMedico.nome())) {
            this.nome = dadosAtualizacaoMedico.nome();
        }

        if (nonNull(dadosAtualizacaoMedico.telefone())) {
            this.telefone = dadosAtualizacaoMedico.telefone();
        }

        if (nonNull(dadosAtualizacaoMedico.enable())) {
            this.enable = dadosAtualizacaoMedico.enable();
        }

        if (nonNull(dadosAtualizacaoMedico.endereco())) {
            this.endereco.atualizar(dadosAtualizacaoMedico.endereco());
        }
    }

}
