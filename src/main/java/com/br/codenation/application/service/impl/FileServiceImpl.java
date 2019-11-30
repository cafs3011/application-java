package com.br.codenation.application.service.impl;

import com.br.codenation.application.annotations.AnnotationMethod;
import com.br.codenation.application.service.IFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class FileServiceImpl implements IFileService {

    ApplicationService applicationService = new ApplicationService();

    @Override
    @AnnotationMethod(text="teste")
    public void LoadArquivoEmpresa() throws IOException {
        //EmpresaController empresaController = new EmpresaController();
        BufferedReader br = new BufferedReader(new FileReader("/Users/cintia/codenation/arquivos/empresa.txt"));
        int id = 0;
        while (br.ready()) {
            String linha = br.readLine();
            if (id == 0) {
                id++;
            } else {

                String[] linhas = linha.split(";");
               // System.out.println(linha);
               // System.out.println(linhas);

                applicationService.createEmpresa(id, linhas[0], linhas[1], new Integer(linhas[2]), linhas[3]);
                id++;
            }

        }
        br.close();
    }

    @Override
    @AnnotationMethod(text="teste")
    public void LoadArquivoUsuario() throws IOException {
        // ApplicationService usuarioController = new UsuarioController();
        int id = 0;
        BufferedReader br = new BufferedReader(new FileReader("/Users/cintia/codenation/arquivos/usuarios.txt"));
        while (br.ready()) {
            String linha = br.readLine();
            if(id == 0){
                id++;
            }
            else if (id > 0) {

                String[] linhas = linha.split(";");
               // System.out.println(linha);
              //  System.out.println(linhas);
                String senha = linhas[4].replace("u","#0P")
                        .replace("s","[%0")
                        .replace("e","lD7")
                        .replace("r","çA=");
                applicationService.createUsuario(id, linhas[0], linhas[1],
                        new Integer(linhas[2]), linhas[3],
                        senha, new Integer(linhas[5]), new BigDecimal(linhas[6]));
                id++;
            }
        }
        br.close();

    }


}
