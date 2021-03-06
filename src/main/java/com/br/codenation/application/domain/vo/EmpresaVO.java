package com.br.codenation.application.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaVO {
    private Long id;

    private int vagas;
    private String site;
    private String nome;
    private String documento;

    private EnderecoVO endereco;
    private BigDecimal averageSalary;
}
