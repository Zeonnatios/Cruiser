package br.senac.tads.pi3.filter;

import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cruiser
 */
@WebFilter(filterName = "Filtro", urlPatterns = {"/protegido/*"}, servletNames = {"HomeServlet"})
public class Filtro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //VERIFICANDO SE USUÁRIO ESTÁ LOGADO
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("f") == null) {
            //NÃO ESTÁ LOGADO ENTÃO VAI PARA A TELA DE LOGIN
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login");
            return;
        }

        Funcionario funcionario = (Funcionario) sessao.getAttribute("f");

        if (verificarAcesso(funcionario, httpRequest)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro.jsp");
        }

    }

    private boolean verificarAcesso(Funcionario funcionario, HttpServletRequest httpRequest) {
        String urlAcessada = httpRequest.getRequestURI();
        String departamento = funcionario.getDepartamento();
        if (urlAcessada.endsWith("/home")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/listar_funcionarios") && departamento.equals("Tecnologia")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/funcionario_novo") && departamento.equals("Tecnologia")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/listar_filiais") && departamento.equals("Tecnologia")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/filial_novo") && departamento.equals("Tecnologia")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/carrinho") && (departamento.equals("Tecnologia") || departamento.equals("Vendas") || departamento.equals("Diretoria") || departamento.equals("Gerencia"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/vendaPeriodo") && (departamento.equals("Tecnologia") || departamento.equals("Vendas") || departamento.equals("Diretoria") || departamento.equals("Gerencia"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/vendaDetalhada") && (departamento.equals("Tecnologia") || departamento.equals("Vendas") || departamento.equals("Diretoria") || departamento.equals("Gerencia"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/listar_produtos") && (departamento.equals("Tecnologia") || departamento.equals("Marketing/Produtos"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/produto_novo") && (departamento.equals("Tecnologia") || departamento.equals("Marketing/Produtos"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/listar_clientes") && (departamento.equals("Tecnologia") || departamento.equals("Vendas"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/cliente_novo") && (departamento.equals("Tecnologia") || departamento.equals("Vendas"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/diario") && (departamento.equals("Tecnologia") || departamento.equals("Diretoria") || departamento.equals("Gerencia"))) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/mensal") && (departamento.equals("Tecnologia") || departamento.equals("Diretoria") || departamento.equals("Gerencia"))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
