package br.com.bank.service;

import br.com.bank.model.dto.UserWSDTO;
import br.com.bank.model.form.UsuarioForm;

public interface UserService {

    UserWSDTO buscarClientePorCpf (String cpf);

    UserWSDTO criarUsuario (UsuarioForm usuarioForm);

    void ataulizarUsuario (String cpf, String nome);

    void removerUsuario (String cpf);

}
