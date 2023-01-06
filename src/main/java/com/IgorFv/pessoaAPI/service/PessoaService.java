package com.IgorFv.pessoaAPI.service;

import com.IgorFv.pessoaAPI.Dtos.Pessoa;
import com.IgorFv.pessoaAPI.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Transactional
    public ResponseEntity<Pessoa> consultar(Long pessoaId){
        return pessoaRepository.findById(pessoaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public Pessoa adicionar(Pessoa pessoa){
        boolean nomeEmUso = pessoaRepository.findByNome(pessoa.getNome())
                .stream()
                .anyMatch(pessoaExistente -> !pessoaExistente.equals(pessoa));

        if (nomeEmUso){
            throw new RuntimeException("O Nome informado Já esta em Uso, Tente Outro por favor");
        }
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public ResponseEntity<Pessoa> atualizar(Long pessoaId, Pessoa pessoa){
        if (!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(pessoa);
    }
}
