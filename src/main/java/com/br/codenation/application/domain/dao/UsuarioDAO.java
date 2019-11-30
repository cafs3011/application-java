package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Empresa;
import com.br.codenation.application.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query(value = "UPDATE usuario SET nome = :nome WHERE id = :id", nativeQuery = true)
    void atualizarNome(@Param("id") Long id, @Param("nome") String nome);


    Usuario getByUsername(String username);

   // @Query(value="UPDATE usuario SET empresa_id = :idEmpresa WHERE id = :id", nativeQuery = true)
   // void alterarEmpresa(@Param("id") Long id, @Param("empresa_id") Long idEmpresa);
}
