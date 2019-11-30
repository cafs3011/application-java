package com.br.codenation.application.service;

import com.br.codenation.application.domain.entity.Empresa;
import com.br.codenation.application.domain.vo.CompanyAvgVO;
import com.br.codenation.application.domain.vo.EmpresaVO;
import com.br.codenation.application.domain.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public interface IEmpresaService {

	EmpresaVO create(EmpresaVO empresa);

    Empresa getEmpresa(Long idEmpresa);

	List<EmpresaVO> findByName(String name);

	Long getCount();

	void delete(Long id) throws Exception;

	EmpresaVO changeVagas(EmpresaVO empresaVO) throws Exception;
	List<CompanyAvgVO>  getAverageSalary();
}