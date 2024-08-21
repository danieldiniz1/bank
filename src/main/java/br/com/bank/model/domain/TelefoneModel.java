package br.com.bank.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(of = {"ddd","numero"})
@Entity(name = "tb_telefones")
public class TelefoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String numero;
    private String ddd;
    private String isoCode;

    public static TelefoneModel valueOf(String numero, String ddd, String isoCode) {
        TelefoneModel model = new TelefoneModel();
        model.setNumero(numero);
        model.setDdd(ddd);
        model.setIsoCode(isoCode);
        return model;
    }

}
