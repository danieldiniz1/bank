package br.com.bank.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_endereco")
@Data
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private boolean enderecoPrincipal;

    @Column(nullable = false, unique = true)
    private String cep;

    private String logradouro,numero,complemento,bairro,cidade,uf,pais;
}
