package br.com.bank.model.dto;

public record UserWSDTO(String nome,
                        String dataNascimento,
                        TelefoneWSDTO telefone,
                        EnderecoWSDTO endereco) {

}
