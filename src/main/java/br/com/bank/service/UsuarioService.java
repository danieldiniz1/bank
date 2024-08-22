package br.com.bank.service;

import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.model.dto.UsuarioWSDTO;
import br.com.bank.model.form.UsuarioForm;

public interface UsuarioService {

    UsuarioModel buscarClientePorCpf (String cpf);

    UsuarioModel criarUsuario (UsuarioModel usuarioForm);

    void ataulizarUsuario (String cpf, String nome);

    void removerUsuario (String cpf);
}
