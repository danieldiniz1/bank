package br.com.bank.controller;

import br.com.bank.model.dto.UserWSDTO;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.service.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final UserService userService;

    public UserController (final UserService userService) {this.userService = userService;}

    @GetMapping
    public ResponseEntity<UserWSDTO> buscarUsuario (@PathVariable() String cpf) {

        return ResponseEntity.status(200).body(userService.buscarClientePorCpf(cpf));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarUsuario (@Valid @RequestBody UsuarioForm user) {
        userService.criarUsuario(user);
        return ResponseEntity.status(200).build();
    }

}
