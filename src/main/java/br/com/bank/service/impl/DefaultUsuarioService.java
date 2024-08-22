package br.com.bank.service.impl;

import br.com.bank.exception.ModelNotFoundException;
import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.repository.UsuarioRepository;
import br.com.bank.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUsuarioService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    protected DefaultUsuarioService (final UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioModel buscarClientePorCpf (final String cpf) {

        return usuarioRepository.findByCpf(cpf).orElseThrow(() -> new ModelNotFoundException("Usuário não encontrado"));
    }

    @Override
    public UsuarioModel criarUsuario (final UsuarioModel usuarioModel) {

        try {
            return usuarioRepository.save(usuarioModel);
        } catch (Exception e) {
            throw new ModelNotFoundException(e.getMessage());
        }
    }

    @Override
    public void ataulizarUsuario (final String cpf, final String nome) {

    }

    @Override
    public void removerUsuario (final String cpf) {

    }

}
