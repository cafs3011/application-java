package com.br.codenation.application.service.impl;
import java.math.BigDecimal;
import com.br.codenation.application.service.IApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationService implements IApplicationService {

    private Logger LOG = LoggerFactory.getLogger(ApplicationService.class);

    @Override
    public void createUsuario(int id, String nome, String documento, int idade, String login, String senha, int idEmpresa, BigDecimal salario) {

    }

    @Override
    public void createEmpresa(int id, String nome, String documento, int vagas, String site) {

    }

    @Override
    public String findUsuario(int idEmpresa, String nomeEmpresa, String documento, int idade) {
        return null;
    }

    @Override
    public void printEmpresaSalario() {

    }

    @Override
    public void printMaiorSalarioGeral() {

    }

    @Override
    public void printEmpresaTotalSalario() {

    }

    @Override
    public void printEmpresaMediaSalario() {

    }

    @Override
    public void printEmpresaMenorCusto() {

    }

    @Override
    public void printEmpresaMediaIdade() {

    }

    @Override
    public void printEmpresaUsuarioOrdenadosIdade() {

    }

  /*  private static List<Empresa> lstEmpresa = new ArrayList<Empresa>();
    private static List<Usuario> lstUsuario = new ArrayList<Usuario>();

    private void validateUsuario(int id, String nome, String documento, String login, String senha, int idEmpresa) {

        if (StringUtils.isEmpty(nome)) {
            throw new CodenationException("#### ERROR - Não foi informado o nome para o usuário.");
        }
        if (StringUtils.isEmpty(documento)) {
            throw new CodenationException("#### ERROR - Não foi informado o documento para o usuário.");
        }
        if (StringUtils.isEmpty(login)) {
            throw new CodenationException("#### ERROR - Não foi informado o login para o usuário.");
        }
        if (StringUtils.isEmpty(senha)) {
            throw new CodenationException("#### ERROR - Não foi informado a senha para o usuário.");
        }

        if (lstUsuario.stream().anyMatch(usuario -> usuario.getNome().equals(nome))) {
            throw new CodenationException("#### ERROR - Já existe um usuário cadastrado com o nome informado: '" + nome + "'.");
        }
        if (lstUsuario.stream().anyMatch(usuario -> usuario.getDocumento().equals(documento))) {
            throw new CodenationException("#### ERROR - Já existe uma usuário cadastrado com o documento informado: '" + documento + "'.");
        }
        if (lstUsuario.stream().anyMatch(usuario -> usuario.getLogin().equals(login))) {
            throw new CodenationException("#### ERROR - Já existe um usuário cadastrado com o login informado: '" + login + "'.");
        }
        Empresa empresa = lstEmpresa.stream().filter(emp -> emp.getId() == idEmpresa).findFirst().orElse(null);
        if (empresa == null) {
            throw new CodenationException("#### ERROR - Não foi encontrado empresa com o id informado: '" + id + "'");
        }
        if (empresa.getVagas() == 0) {
            throw new CodenationException("#### ERROR - A empresa com o id informado: '" + idEmpresa + "' não tem vagas disponíveis.");
        }
    }

    private void validateEmpresa(int id, String nome, String documento) {

        if (lstEmpresa.stream().anyMatch(emp -> emp.getId() == id)) {
            throw new CodenationException("#### ERROR - Já existe uma empresa cadastrada com o id informado: '" + id + "'.");
        }
        if (lstEmpresa.stream().anyMatch(empresa -> empresa.getNome().equals(nome))) {
            throw new CodenationException("#### ERROR - Já existe uma empresa cadastrada com o nome informado: '" + nome + "'.");
        }
        if (lstEmpresa.stream().anyMatch(empresa -> empresa.getDocumento().equals(documento))) {
            throw new CodenationException("#### ERROR - Já existe uma empresa cadastrada com o documento informado: '" + documento + "'.");
        }
    }

    public void createUsuario(int id, String nome, String documento, int idade, String login, String senha, int idEmpresa, BigDecimal salario) {

        validateUsuario(id, nome, documento, login, senha, idEmpresa);
        Empresa empresa = lstEmpresa.stream().filter(emp -> emp.getId() == idEmpresa).findFirst().orElse(null);
        empresa.setVagas(empresa.getVagas() - 1);
        Usuario usuario = new Usuario(id, nome, documento, idade, login, senha, empresa, salario);
        empresa.adicionarUsuario(usuario);
        lstUsuario.add(usuario);
        LOG.info("Usuario criado com sucesso {}", usuario);
    }

    public void createEmpresa(int id, String nome, String documento, int vagas, String site) {
        validateEmpresa(id, nome, documento);
        Empresa empresa = new Empresa(id, nome, documento, vagas, site);
        lstEmpresa.add(empresa);
        LOG.info("Empresa criada com sucesso {}", empresa);
    }

    public String findUsuario(int idEmpresa, String nomeEmpresa, String documento, int idade) {
        List<Usuario> lstUsuarioFiltrados = lstUsuario.stream().filter(
                usuario ->
                        (StringUtils.isEmpty(nomeEmpresa) || usuario.getEmpresa().getNome().equals(nomeEmpresa)) &&
                                (idEmpresa == 0 || usuario.getEmpresa().getId() == idEmpresa) &&
                                (StringUtils.isEmpty(documento) || usuario.getDocumento().equals(documento)) &&
                                (idade == 0 || usuario.getIdade() == idade)
        ).collect(Collectors.toList());
        return lstUsuarioFiltrados.toString();
    }

    public void printEmpresaSalario() {
        lstUsuario.forEach(usuario -> LOG.info("Usuário: {} Salário: R${}", usuario.getNome(),
                usuario.getSalario()));

        for (int i = 0; i < lstEmpresa.size(); i++) {
            Usuario usuarioMaiorSalario = lstEmpresa.get(i).getLstUsuario().stream().max(Comparator.comparing(Usuario::getSalario)).orElseThrow(NoSuchElementException::new);
            LOG.info("Empresa: {} - Usuário: {} - Salário: R${}", usuarioMaiorSalario.getEmpresa().getNome(),
                    usuarioMaiorSalario.getNome(), usuarioMaiorSalario.getSalario());
        }
    }

    private BigDecimal getTotalSalario(List<Usuario> usuarios) {
        return usuarios.stream().map(Usuario::getSalario).reduce(BigDecimal::add).get();
    }

    public void printMaiorSalarioGeral() {
        Usuario usuarioMaiorSalarioGeral = lstUsuario.stream().max(Comparator.comparing(Usuario::getSalario)).orElseThrow(NoSuchElementException::new);
        LOG.info("Maior Salário Geral: Usuário: {} - Empresa: {} - Salário: R${}",
                usuarioMaiorSalarioGeral.getNome(),
                usuarioMaiorSalarioGeral.getEmpresa().getNome(),
                usuarioMaiorSalarioGeral.getSalario());
    }

    public void printEmpresaTotalSalario() {
        for (int i = 0; i < lstEmpresa.size(); i++) {
            BigDecimal sum = getTotalSalario(lstEmpresa.get(i).getLstUsuario());
            LOG.info("Empresa: {} - Total Salário: R${}", lstEmpresa.get(i).getNome(), sum);
        }
    }


    @Override
    public void printEmpresaMediaSalario() {
        for (int i = 0; i < lstEmpresa.size(); i++) {
            BigDecimal avg = getMediaSalario(lstEmpresa.get(i).getLstUsuario());
            LOG.info("Empresa: {} - Media Salário: R${}", lstEmpresa.get(i).getNome(), avg);
        }
    }

    @Override
    public void printEmpresaMenorCusto() {

        Empresa empresaMenorCusto = null;
        BigDecimal valorTotal = null;
        for (Empresa empresa :
             lstEmpresa) {

            if(empresaMenorCusto == null){
                empresaMenorCusto = empresa;
                valorTotal = getTotalSalario(empresa.getLstUsuario());
            }
            else if(getTotalSalario(empresa.getLstUsuario()).compareTo(valorTotal) < 0){
                empresaMenorCusto = empresa;
                valorTotal = getTotalSalario(empresa.getLstUsuario());
            }
        }
        LOG.info("Empresa com menor custo: {} - Total: R${}", empresaMenorCusto.getNome(), valorTotal);
    }

    @Override
    public void printEmpresaMediaIdade() {

        for (int i = 0; i < lstEmpresa.size(); i++) {
            Double avg = lstEmpresa.get(i).getLstUsuario().stream().mapToInt(Usuario::getIdade).average().getAsDouble();
            LOG.info("Empresa: {} - Média Idade: {}", lstEmpresa.get(i).getNome(), avg.shortValue());
        }
    }

    @Override
    public void printEmpresaUsuarioOrdenadosIdade() {
        for (int i = 0; i < lstEmpresa.size(); i++) {
            List<Usuario> usuarioOrdenados = lstEmpresa.get(i).getLstUsuario().stream().sorted(Comparator.comparing(Usuario::getIdade)).collect(Collectors.toList());
            for (Usuario usuario :
                    usuarioOrdenados) {
                LOG.info("Empresa: {} - Usuario: {} - Idade {}", usuario.getEmpresa().getNome(), usuario.getNome(), usuario.getIdade());
            }
        }
    }

    private BigDecimal getMediaSalario(List<Usuario> usuarios) {
        BigDecimal sum = getTotalSalario(usuarios);
        BigDecimal avg;
        if (usuarios == null || usuarios.size() == 0) {
            avg = new BigDecimal(0);
        } else {
            BigDecimal count = new BigDecimal(usuarios.size());
            avg = sum.divide(count, RoundingMode.HALF_EVEN);
        }
        return avg;
    }


*/


}
