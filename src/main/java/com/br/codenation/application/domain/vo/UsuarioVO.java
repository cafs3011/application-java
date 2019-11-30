package com.br.codenation.application.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Model de Usuário")
public class UsuarioVO  {

    private Long id;
    private String nome;
    private String documento;
    private int idade;
    private String login;
    private BigDecimal salario;
    private String senha;
    private EnderecoVO endereco;
    private Long idEmpresa;

}
