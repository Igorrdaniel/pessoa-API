package com.IgorFv.pessoaAPI.controller;

import com.IgorFv.pessoaAPI.Dtos.Pessoa;
import com.IgorFv.pessoaAPI.repository.PessoaRepository;
import com.IgorFv.pessoaAPI.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<Pessoa> consultar(@PathVariable Long pessoaId) {
        return pessoaService.consultar(pessoaId);
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicioanar(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.adicionar(pessoa);
    }

    @PutMapping("/atualizar/{pessoaId}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizar(pessoaId, pessoa);
    }

}
