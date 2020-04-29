/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.dao.FuncionarioDao;
import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukas
 */
@WebServlet(name = "ContasServlet", urlPatterns = {"/contas"})
public class ContasServlet extends HttpServlet {

    private FuncionarioDao dao = new FuncionarioDao();

    public ContasServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contas.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String departamento = request.getParameter("departamento");
        String status = request.getParameter("status");

        Funcionario funcionario = new Funcionario();

        funcionario.setIdFuncionario(idFuncionario);
        funcionario.setNome(nome);
        funcionario.setEmail(email);
        funcionario.setSenha(senha);
        funcionario.setCidade(cidade);
        funcionario.setDepartamento(departamento);
        funcionario.setStatus(status);

        try {
            dao.inserirFuncionario(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(ContasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Menssagem.jsp");
        dispatcher.forward(request, response);
    }
}
