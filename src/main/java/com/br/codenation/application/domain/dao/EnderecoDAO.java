package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Long> {

}