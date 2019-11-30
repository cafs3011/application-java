package com.br.codenation.application.service;

import com.br.codenation.application.exceptions.CodenationException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public interface IApplicationService {


    void createUsuario(int id, String nome, String documento, int idade, String login, String senha, int idEmpresa, BigDecimal salario);

    void createEmpresa(int id, String nome, String documento, int vagas, String site);

    String findUsuario(int idEmpresa, String nomeEmpresa, String documento, int idade);

    void printEmpresaSalario();

    void printMaiorSalarioGeral();

    void printEmpresaTotalSalario();

    void printEmpresaMediaSalario();

    void printEmpresaMenorCusto();

    void printEmpresaMediaIdade();

    void printEmpresaUsuarioOrdenadosIdade();
}


