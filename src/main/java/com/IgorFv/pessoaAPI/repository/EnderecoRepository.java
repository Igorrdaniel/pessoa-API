package com.IgorFv.pessoaAPI.repository;

import com.IgorFv.pessoaAPI.Dtos.Endereco;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
