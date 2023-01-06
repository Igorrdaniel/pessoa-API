package com.IgorFv.pessoaAPI.service;

import com.IgorFv.pessoaAPI.Dtos.Endereco;
import com.IgorFv.pessoaAPI.Dtos.Pessoa;
import com.IgorFv.pessoaAPI.repository.EnderecoRepository;
import com.IgorFv.pessoaAPI.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private PessoaRepository pessoaRepository;

    @Transactional
    public Endereco registrar(Endereco endereco){
        Pessoa pessoa = pessoaRepository.findById(endereco.getPessoa().getId())
                        .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);


    }
}
