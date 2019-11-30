package com.br.codenation.application;

import com.br.codenation.application.controller.EmpresaController;
import com.br.codenation.application.controller.FileController;
import com.br.codenation.application.controller.UsuarioController;
import com.br.codenation.application.service.impl.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@SpringBootApplication
@Configuration
@EnableScheduling
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

      /*  EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        factory.close();*/

        /*
        FileController fileController = new FileController();
        UsuarioController usuarioController = new UsuarioController();
        EmpresaController empresaController = new EmpresaController();

        fileController.LoadArquivoEmpresa();
        fileController.LoadArquivoUsuario();


        //        Imprima o maior salário de cada empresa e o maior
        //        salário geral.
        empresaController.printEmpresaSalario();
        empresaController.printMaiorSalarioGeral();

        //Imprima a média salarial de cada empresa.
        empresaController.printEmpresaMediaSalario();


        // Imprima o valor total da folha de cada empresa.
        empresaController.printEmpresaTotalSalario();

        //  Imprima qual a empresa que tem o menor custo.
        empresaController.printEmpresaMenorCusto();

        //  Imprima a média de idade por empresa.
        empresaController.printEmpresaMediaIdade();

        //  Ordene e imprima todos os usuários por idade em
        //  cada empresa.
        empresaController.printEmpresaUsuarioOrdenadosIdade();




        /*
        UsuarioController usuarioController = new UsuarioController();
        EmpresaController empresaController = new EmpresaController();
        empresaController.createEmpresa(1, "Codenation", "31471046000137", 2, "");
        empresaController.createEmpresa(1, "Codenation", "31471046000138", 3, "");
        empresaController.createEmpresa(4, "Codenation", "31471046000137", 3, "");
        empresaController.createEmpresa(2, "Fiat", "34567876000123", 4, "");
        empresaController.createEmpresa(3, "Inter", "23456765000145", 1, "");


        usuarioController.createUsuario(1, "Thiago", "123456789", 31, "oathiago", "codenation",1, new BigDecimal(0));
        usuarioController.createUsuario(2, "Carlos", "817287128", 31, "carlosab", "123456",1, new BigDecimal(0));
        usuarioController.createUsuario(3, "Bruno", "187287182", 31, "brunoer", "123456",1, new BigDecimal(0));
        usuarioController.createUsuario(1, "Carla", "1234567999", 31, "carla", "codenation",2, new BigDecimal(0));
        usuarioController.createUsuario(2, "Cintia", "8172887128", 20, "cintia", "123456",2, new BigDecimal(0));
        usuarioController.createUsuario(3, "Paola", "1872877182", 28, "paola", "123456",1, new BigDecimal(0));

        usuarioController.createUsuario(4, "", "187287182", 28, "brunoer", "123456",8, new BigDecimal(0));
        usuarioController.createUsuario(5, "Bruno", "", 28, "brunoer", "123456",8, new BigDecimal(0));
		usuarioController.createUsuario(6, "Bruno", "187287182", 28, "", "123456",8, new BigDecimal(0));
		usuarioController.createUsuario(7, "Bruno", "12345", 28, "brunoer", null,8, new BigDecimal(0));

		usuarioController.createUsuario(8, "Bruno", "187287182", 28, "brunoer", "123456",3, new BigDecimal(0));
		usuarioController.createUsuario(9, "Joao", "187287183", 28, "brunoer", "123456",3, new BigDecimal(0));
		usuarioController.createUsuario(10, "Pablo", "187287182", 28, "pablo123", "1234",3, new BigDecimal(0));


        usuarioController.findUsuario(1, null,"",0);
        usuarioController.findUsuario(1, "","123456789",0);
        usuarioController.findUsuario(0, "","",31);*/
        /*
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        System.out.println(desafio.buscarTopJogadores(10));

        desafio.incluirTime(new Long(2),"Flamengo", LocalDate.now(),"Vermelho", "Azul");
        desafio.incluirTime(new Long(3),"Cruzeiro", LocalDate.now(),"Azul", "Branco");
        desafio.incluirTime(new Long(4),"Atletico", LocalDate.now(),"Preto", "Azul");
        desafio.incluirTime(new Long(1),"America", LocalDate.now(),"Verde", "Branco");
        desafio.incluirTime(new Long(5),"santos", LocalDate.now(),"Preto", "Branco");

        System.out.println(desafio.buscarJogadoresDoTime(new Long(1)));

        desafio.incluirJogador(new Long(2),new Long(1),
                "Joao da Silva1", LocalDate.of(1998, 5, 2),90, new BigDecimal(5000));
        desafio.incluirJogador(new Long(4),new Long(1),
                "Joao da Silva2", LocalDate.of(1990, 5, 2),99, new BigDecimal(3000));
        desafio.incluirJogador(new Long(3),new Long(1),
                "Joao da Silva3", LocalDate.of(1970, 5, 2),99, new BigDecimal(4000));
        desafio.incluirJogador(new Long(1),new Long(1),
                "Joao da Silva4", LocalDate.of(1970, 5, 2),92, new BigDecimal(5000));

        desafio.incluirJogador(new Long(5),new Long(2),
                "Joao da Silva5", LocalDate.of(1991, 5, 2),98, new BigDecimal(5000));
        desafio.definirCapitao(new Long(2));

        System.out.println(desafio.buscarCapitaoDoTime(new Long(1)));

        desafio.definirCapitao(new Long(4));

        System.out.println(desafio.buscarCapitaoDoTime(new Long(1)));

        desafio.definirCapitao(new Long(5));
        System.out.println(desafio.buscarCapitaoDoTime(new Long(2)));

        System.out.println(desafio.buscarNomeJogador(new Long(2)));
        System.out.println(desafio.buscarNomeTime(new Long(1)));

        System.out.println(desafio.buscarCorCamisaTimeDeFora(new Long(1), new Long(2)));

        System.out.println(desafio.buscarCorCamisaTimeDeFora(new Long(3), new Long(5)));

        System.out.println(desafio.buscarJogadoresDoTime(new Long(1)));
        System.out.println(desafio.buscarJogadoresDoTime(new Long(2)));

        System.out.println("Melhor Jogador"+desafio.buscarMelhorJogadorDoTime(new Long(1)));
        System.out.println("Maior Salario"+desafio.buscarJogadorMaiorSalario(new Long(1)));
        System.out.println("Mais velho"+desafio.buscarJogadorMaisVelho(new Long(1)));


        System.out.println(desafio.buscarTimes());

        System.out.println(desafio.buscarTopJogadores(10));*/

    }

    //region Testes
    private static void LoadUsuario() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/cintia/codenation/arquivos/usuarios.txt"));
        while (br.ready()) {
            String linha = br.readLine();
            String[] linhas = linha.split(";");
            System.out.println(linha);
            System.out.println(linhas);
            for (int i = 0; i < linhas.length; i++) {

            }
        }
        br.close();
    }

    private static void LoadEmpresa() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/cintia/codenation/arquivos/empresa.txt"));
        while (br.ready()) {
            String linha = br.readLine();
            System.out.println(linha);
        }
        br.close();
    }
    //endregion
}

