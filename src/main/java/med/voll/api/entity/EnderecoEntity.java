package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.dto.DadosEndereco;

import static java.util.Objects.nonNull;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private Integer numero;
    private String complemento;

    public EnderecoEntity(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
    }

    public void atualizar(DadosEndereco endereco) {
        if (nonNull(endereco.bairro())) {
            this.bairro = endereco.bairro();
        }
        if (nonNull(endereco.cep())) {
            this.cep = endereco.cep();
        }
        if (nonNull(endereco.cidade())) {
            this.cidade = endereco.cidade();
        }
        if (nonNull(endereco.complemento())) {
            this.complemento = endereco.complemento();
        }
        if (nonNull(endereco.logradouro())) {
            this.logradouro = endereco.logradouro();
        }
        if (nonNull(endereco.numero())) {
            this.numero = endereco.numero();
        }
        if (nonNull(endereco.uf())) {
            this.uf = endereco.uf();
        }
    }
}
