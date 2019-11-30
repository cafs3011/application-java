package com.br.codenation.application.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileService {

    void LoadArquivoEmpresa() throws IOException;

    void LoadArquivoUsuario() throws IOException;
}
