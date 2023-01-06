package com.IgorFv.pessoaAPI.controller;

import com.IgorFv.pessoaAPI.Dtos.Endereco;
import com.IgorFv.pessoaAPI.repository.EnderecoRepository;
import com.IgorFv.pessoaAPI.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private EnderecoService enderecoService;
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@Valid @RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);

    }
}
