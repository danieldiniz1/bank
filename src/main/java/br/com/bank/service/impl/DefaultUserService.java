package br.com.bank.service.impl;

import br.com.bank.model.domain.EnderecoModel;
import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.model.dto.EnderecoWSDTO;
import br.com.bank.model.dto.TelefoneWSDTO;
import br.com.bank.model.dto.UserWSDTO;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.repository.UsuarioRepository;
import br.com.bank.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DefaultUserService implements UserService {

    private final UsuarioRepository usuarioRepository;

    protected DefaultUserService (final UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserWSDTO buscarClientePorCpf (final String cpf) {

        return populateUser(usuarioRepository.findByCpf(cpf));
    }

    @Override
    public UserWSDTO criarUsuario (final UsuarioForm usuarioForm) {
        UsuarioModel userModel = createUserModel(usuarioForm);
        return populateUser(usuarioRepository.save(userModel));
    }

    @Override
    public void ataulizarUsuario (final String cpf, final String nome) {

    }

    @Override
    public void removerUsuario (final String cpf) {

    }

    private UserWSDTO populateUser (final UsuarioModel user) {

        final EnderecoModel enderecoModel = user.getEnderecoList().stream()
          .filter(e -> Boolean.TRUE.equals(e.isEnderecoPrincipal())).findFirst().orElse(null);
        return new UserWSDTO(user.getNome(),
                             user.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                             new TelefoneWSDTO(user.getTelefone().getDdd(),user.getTelefone().getNumero()),
                             new EnderecoWSDTO(enderecoModel != null ? enderecoModel.getCep() : "endereço nao cadastrado") );
    }

    private UsuarioModel createUserModel (final UsuarioForm usuarioForm) {
        UsuarioModel usuarioModel = UsuarioModel.valueOf();
        usuarioModel.setAtivo(usuarioForm.ativo());
        usuarioModel.setCpf(usuarioForm.cpf());
        usuarioModel.setNome(usuarioForm.nome());
        usuarioModel.setDataNascimento(LocalDate.parse(usuarioForm.dataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return usuarioModel;
    }

}
