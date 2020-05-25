/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.exception.HomeException;
import br.senac.tads.pi3.controller.HomeService;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    private HomeService service = new HomeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int clientesTotal = service.registrosClientes(); //total de registros de clientes
            int funcionarioTotal = service.registrosFuncionariosTotal(); //total de registros de funcionarios
            int funcionarioAtivos = service.registrosFuncionariosAtivos(); //total de registros de funcionarios ativos
            int produtosEstoque = service.totalEstoque(); //total de produtos em entoque
            int produtoTotal = service.registroProdutoTotal(); //total de registros de produtos em estoque
            //System.out.println("Linhas " + Integer.toString(nRegistros));

            HttpSession sessao = request.getSession();
            sessao.setAttribute("listarClientes", Integer.toString(clientesTotal));
            sessao.setAttribute("funcionariosTotal", Integer.toString(funcionarioTotal));
            sessao.setAttribute("funcionariosAtivos", Integer.toString(funcionarioAtivos));
            sessao.setAttribute("totalEstoque", Integer.toString(produtosEstoque));
            sessao.setAttribute("produtoTotal", Integer.toString(produtoTotal));

            //Os dados contidos nos objetos do método listarClientes
            //são passados a página jsp através do setAttribute
        } catch (HomeException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
