package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.EmpresaDAO;
import com.br.codenation.application.domain.entity.Empresa;
import com.br.codenation.application.domain.entity.Endereco;
import com.br.codenation.application.domain.entity.Usuario;
import com.br.codenation.application.domain.vo.EmpresaVO;
import com.br.codenation.application.domain.vo.EnderecoVO;
import com.br.codenation.application.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    EmpresaDAO empresaDAO;

    @Override
    @Transactional
    public EmpresaVO create(EmpresaVO empresaVO){
        Empresa empresa = EmpresaVOToEntity(empresaVO);
        empresa = empresaDAO.save(empresa);
        return EntityToEmpresaVO(empresa);
    }

    @Override
    public Long getCount(){
        return empresaDAO.count();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empresaDAO.deleteById(id);

    }

    @Override
    public Empresa getEmpresa(Long idEmpresa) {
        return empresaDAO.getOne(idEmpresa);
    }

    @Override
    public List<EmpresaVO> findByName(String name) {
        List<Empresa> lstEmpresa = empresaDAO.findByNomeLikeOrderByNome("%"+name+"%");
        return lstEmpresa.stream().map(empresa -> EntityToEmpresaVO(empresa))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmpresaVO changeVagas(EmpresaVO empresaVO) throws Exception {
        Empresa empresa = empresaDAO.findById(empresaVO.getId()).orElse(null);

        if (empresa == null) {
            throw new Exception("Não foi encontrado empresa com o id informado: " + empresaVO.getId() + "'.");
        }
        empresa.setVagas(empresaVO.getVagas());
        empresa = empresaDAO.save(empresa);
        return EntityToEmpresaVO(empresa);
    }

    public EmpresaVO EntityToEmpresaVO(Empresa empresa){
        return EmpresaVO
                .builder()
                .id(empresa.getId())
                .documento(empresa.getDocumento())
                .site(empresa.getSite())
                .vagas(empresa.getVagas())
                .nome(empresa.getNome())
                .endereco(
                        EnderecoVO.builder()
                                .id(empresa.getEndereco().getId())
                                .logradouro(empresa.getEndereco().getLogradouro())
                                .numero(empresa.getEndereco().getNumero())
                                .cep(empresa.getEndereco().getCep())
                                .cidade(empresa.getEndereco().getCidade())
                                .estado(empresa.getEndereco().getEstado())
                                .pais(empresa.getEndereco().getPais())
                                .build()).build();
    }
    public Empresa EmpresaVOToEntity(EmpresaVO empresaVO){
        return Empresa
                .builder()
                .documento(empresaVO.getDocumento())
                .site(empresaVO.getSite())
                .vagas(empresaVO.getVagas())
                .nome(empresaVO.getNome())
                .endereco(
                        Endereco.builder()
                                .logradouro(empresaVO.getEndereco().getLogradouro())
                                .numero(empresaVO.getEndereco().getNumero())
                                .cep(empresaVO.getEndereco().getCep())
                                .cidade(empresaVO.getEndereco().getCidade())
                                .estado(empresaVO.getEndereco().getEstado())
                                .pais(empresaVO.getEndereco().getPais())
                                .build()).build();
    }
}