package br.com.bank.service.impl;

import br.com.bank.exception.ModelSimpleSaveException;
import br.com.bank.model.domain.EnderecoModel;
import br.com.bank.model.form.EnderecoForm;
import br.com.bank.repository.EnderecoRepository;
import br.com.bank.service.EnderecoService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEnderecoService implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public DefaultEnderecoService (EnderecoRepository enderecoRepository) {

        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoModel salvarEndereco (final EnderecoModel enderecoModel) {

        try {
            return this.enderecoRepository.save(enderecoModel);
        } catch (Exception e) {
            throw new ModelSimpleSaveException(e.getMessage());
        }
    }

}
