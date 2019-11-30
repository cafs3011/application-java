package com.br.codenation.application.service.impl;
import com.br.codenation.application.domain.dao.EmpresaDAO;
import com.br.codenation.application.domain.dao.UsuarioDAO;
import com.br.codenation.application.domain.entity.*;
import com.br.codenation.application.domain.vo.EnderecoVO;
import com.br.codenation.application.domain.vo.UsuarioVO;
import com.br.codenation.application.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	EmpresaDAO empresaDAO;

	@Override
	@Transactional
	public UsuarioVO create(UsuarioVO usuarioVO) throws Exception {
		Usuario usuario = UsuarioVOToEntity(usuarioVO);
		Empresa empresa = empresaDAO.getOne(usuario.getEmpresa().getId());

		if(empresa == null){
			throw new Exception("Não foi encontrado empresa com o id informado: "+usuario.getEmpresa().getId()+"'.");
		}
		usuario.setEmpresa(empresa);
		usuario = usuarioDAO.save(usuario);
		return EntityToUsuarioVO(usuario);
	}

	@Override
	@Transactional
	public UsuarioVO changeSalario(UsuarioVO usuarioVO) throws Exception {
		Usuario usuario = usuarioDAO.findById(usuarioVO.getId()).orElse(null);

		if (usuario == null) {
			throw new Exception("Não foi encontrado usuário com o id informado: " + usuarioVO.getId() + "'.");
		}
		usuario.setSalario(usuarioVO.getSalario());
		usuario = usuarioDAO.save(usuario);
		return EntityToUsuarioVO(usuario);
	}



	public UsuarioVO EntityToUsuarioVO(Usuario usuario){
		return UsuarioVO
				.builder()
				.id(usuario.getId())
				.documento(usuario.getDocumento())
				.idade(usuario.getIdade())
				.salario(usuario.getSalario())
				.login(usuario.getUsername())
				.nome(usuario.getNome())
				.senha(usuario.getSenha())
				.endereco(
						EnderecoVO.builder()
								.id(usuario.getEndereco().getId())
								.logradouro(usuario.getEndereco().getLogradouro())
								.numero(usuario.getEndereco().getNumero())
								.cep(usuario.getEndereco().getCep())
								.cidade(usuario.getEndereco().getCidade())
								.estado(usuario.getEndereco().getEstado())
								.pais(usuario.getEndereco().getPais())
								.build())
				.idEmpresa(usuario.getEmpresa().getId())
				.build();


	}
	public Usuario UsuarioVOToEntity(UsuarioVO usuarioVO){
		return Usuario
				.builder()
				.id(usuarioVO.getId())
				.documento(usuarioVO.getDocumento())
				.idade(usuarioVO.getIdade())
				.salario(usuarioVO.getSalario())
				.username(usuarioVO.getLogin())
				.nome(usuarioVO.getNome())
				.senha(usuarioVO.getSenha())
				.endereco(
						Endereco.builder()
								.id(usuarioVO.getEndereco().getId())
								.logradouro(usuarioVO.getEndereco().getLogradouro())
								.numero(usuarioVO.getEndereco().getNumero())
								.cep(usuarioVO.getEndereco().getCep())
								.cidade(usuarioVO.getEndereco().getCidade())
								.estado(usuarioVO.getEndereco().getEstado())
								.pais(usuarioVO.getEndereco().getPais())
								.build())
				.empresa(
						Empresa
								.builder()
								.id(usuarioVO.getIdEmpresa()).build())
				.build();
	}
}
