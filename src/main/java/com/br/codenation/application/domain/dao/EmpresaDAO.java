package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Long> {

    ArrayList<Empresa> findByNomeLikeOrderByNome(String nome);

}
