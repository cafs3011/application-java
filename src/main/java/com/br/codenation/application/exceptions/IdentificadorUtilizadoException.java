package com.br.codenation.application.exceptions;

public class IdentificadorUtilizadoException extends RuntimeException {
    public IdentificadorUtilizadoException(String message){
        super(message);
    }
    public IdentificadorUtilizadoException(){
        super();
    }
}
