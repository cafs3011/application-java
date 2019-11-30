package com.br.codenation.application.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoVO {

    private Long id;
    private String cep;
    private String logradouro;
    private int numero;
    private String cidade;
    private String estado;
    private String pais;

}
