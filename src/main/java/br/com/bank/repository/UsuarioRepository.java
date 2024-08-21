package br.com.bank.repository;

import br.com.bank.model.domain.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {

    UsuarioModel findByCpf(String cpf);

}
