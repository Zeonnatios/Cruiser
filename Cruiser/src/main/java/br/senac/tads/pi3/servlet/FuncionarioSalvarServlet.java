/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.FuncionarioService;
import br.senac.tads.pi3.exception.FuncionarioException;
import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
@WebServlet(name = "FuncionarioSalvarServlet", urlPatterns = {"/funcionario_salvar", "/funcionario_update"})
public class FuncionarioSalvarServlet extends HttpServlet {

    private FuncionarioService service = new FuncionarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        //ABRE FORM PARA CADASTRAR
        if (urlInformada.endsWith("_salvar")) {
            request.setCharacterEncoding("UTF-8");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String departamento = request.getParameter("departamento");
            String status = request.getParameter("status");

            Boolean s = false;

            if (status.equals("1")) {
                s = true;
            }
            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setEmail(email);
            f.setSenha(senha);
            f.setCidade(cidade);
            f.setDepartamento(departamento);
            f.setStatus(s);

            HttpSession sessao = request.getSession();

            try {
                service.inserirFuncionario(f);
                sessao.setAttribute("msgSucesso", "Funcionário salvo com sucesso");
            } catch (FuncionarioException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Funcionário - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_funcionarios");

        } else if (urlInformada.endsWith("_update")) {
            //ABRE FORM POPULADO PARA EDITAR, FALTANTE SELECIONAR OS OPTIONS DOS SELECTS NO JSP
            request.setCharacterEncoding("UTF-8");

            //NO JSP SE USAR O DISABLED NO INPUT DE ID, O JSP MANDA PARA O SERVLET O ID COMO NULL
            //VINDO O ID COMO NULL NÃO É POSSIVEL FAZER UPDATE...
            //ENTÃO COM UM INPUT HIDDEN É POSSIVEL PEGAR O ID
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String departamento = request.getParameter("departamento");
            String status = request.getParameter("status");

            Boolean s = false;

            if (status.equals("1")) {
                s = true;
            }

            System.out.println(id + "\n" + nome + "\n" + email + "\n" + senha + "\n" + cidade + "\n" + departamento + "\n" + status);

            Funcionario fun = new Funcionario();
            fun.setIdFuncionario(Integer.parseInt(id));
            fun.setNome(nome);
            fun.setEmail(email);
            fun.setSenha(senha);
            fun.setCidade(cidade);
            fun.setDepartamento(departamento);
            fun.setStatus(s);

            HttpSession sessao = request.getSession();

            try {
                service.editarFuncionario(fun);
                sessao.setAttribute("msgSucesso", "Funcionário editado com sucesso");
            } catch (FuncionarioException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Funcionário - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_funcionarios");
        }

    }

}
