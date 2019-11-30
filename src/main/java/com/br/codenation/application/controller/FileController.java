package com.br.codenation.application.controller;

import com.br.codenation.application.service.IFileService;
import com.br.codenation.application.service.impl.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileController {
    private Logger LOG = LoggerFactory.getLogger(EmpresaController.class);
    IFileService fileService = new FileServiceImpl();

    public void LoadArquivoEmpresa(){
        try{
            fileService.LoadArquivoEmpresa();
        }
        catch (Exception exception) {
            LOG.error(exception.getMessage());
        }
    }

    public void LoadArquivoUsuario(){
        try{
            fileService.LoadArquivoUsuario();
        }
        catch (Exception exception) {
            LOG.error(exception.getMessage());
        }
    }



}
