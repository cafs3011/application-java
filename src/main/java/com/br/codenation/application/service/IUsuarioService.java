package com.br.codenation.application.service;
import com.br.codenation.application.domain.vo.UsuarioVO;


public interface IUsuarioService {

	UsuarioVO create(UsuarioVO usuario) throws Exception;

	UsuarioVO changeSalario(UsuarioVO usuarioVO) throws Exception;

}