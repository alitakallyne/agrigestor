package com.agrigestor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrigestor.model.Agricultor;
import com.agrigestor.repository.AgricultorRepository;

@Service
public class AgricultorService {

	@Autowired
	private  AgricultorRepository repository;
	
	public List<Agricultor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agricultor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agricultor salvar(Agricultor agricultor) {
        if (repository.existsByCpfCnpj(agricultor.getCpfCnpj())) {
            throw new RuntimeException("CPF/CNPJ já cadastrado!");
        }
        return repository.save(agricultor);
    }

    public Agricultor atualizar(Long id, Agricultor dadosAtualizados) {
        return repository.findById(id)
                .map(a -> {
                    a.setNomeCompleto(dadosAtualizados.getNomeCompleto());
                    a.setCpfCnpj(dadosAtualizados.getCpfCnpj());
                    a.setEndereco(dadosAtualizados.getEndereco());
                    a.setTelefone(dadosAtualizados.getTelefone());
                    a.setDataNascimento(dadosAtualizados.getDataNascimento());
                    a.setSexo(dadosAtualizados.getSexo());
                    a.setEscolaridade(dadosAtualizados.getEscolaridade());
                    return repository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Agricultor não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
