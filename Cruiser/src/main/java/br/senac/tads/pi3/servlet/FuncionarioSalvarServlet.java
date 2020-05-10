/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.FuncionarioService;
import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FuncionarioSalvarServlet", urlPatterns = {"/funcionario_salvar"})
public class FuncionarioSalvarServlet extends HttpServlet {

    private FuncionarioService service = new FuncionarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //      int id = Integer.parseInt(request.getParameter("id"));
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

        System.out.println("status" + status);

        Funcionario f = new Funcionario();
        //f.setIdFuncionario(Integer.parseInt(idFuncionario));
        f.setNome(nome);
        f.setEmail(email);
        f.setSenha(senha);
        f.setCidade(cidade);
        f.setDepartamento(departamento);
        f.setStatus(s);

        HttpSession sessao = request.getSession();

        try {
            service.inserirFuncionario(f);
            sessao.setAttribute("Sucesso", "Funcionario salvo com sucesso");
        } catch (Exception ex) {
            sessao.setAttribute("Erro", "Erro ao salvar Funcionario - " + ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/listar_funcionarios");

    }

}
