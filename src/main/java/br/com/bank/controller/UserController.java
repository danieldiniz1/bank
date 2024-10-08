package br.com.bank.controller;

import br.com.bank.facade.UsuarioFacade;
import br.com.bank.model.dto.UsuarioWSDTO;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.model.form.UsuarioUpdateForm;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final UsuarioFacade usuarioFacade;

    public UserController (final UsuarioFacade usuarioFacade) {this.usuarioFacade = usuarioFacade;}

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioWSDTO> buscarUsuario (@PathVariable String cpf) {

        return ResponseEntity.status(200).body(usuarioFacade.buscarClientePorCpf(cpf));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarUsuario (@Valid @RequestBody UsuarioForm usuarioForm) {
        usuarioFacade.criarUsuario(usuarioForm);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping()
    public ResponseEntity atualizarNome (@Valid @RequestBody UsuarioUpdateForm usuarioUpdateForm) {
        usuarioFacade.atualizarNomeUsuario(usuarioUpdateForm);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarUsuario (@PathVariable String cpf) {
        usuarioFacade.removerUsuario(cpf);
        return ResponseEntity.status(200).build();
    }

}
