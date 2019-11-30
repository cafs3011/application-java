package com.br.codenation.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cep", nullable = false, length = 255)
    private String cep;

    @Column(name = "logradouro", nullable = false, length = 255)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 255)
    private int numero;

    @Column(name = "estado", nullable = false, length = 255)
    private String estado;

    @Column(name = "pais", nullable = false, length = 255)
    private String pais;

    @Column(name = "cidade", nullable = false, length = 255)
    private String cidade;

}