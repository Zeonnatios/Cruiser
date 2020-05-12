/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "ProdutoForm", urlPatterns = {"/produto_novo", "/produto_editar"})
public class ProdutoFormServlet extends HttpServlet {

    private ProdutoService service = new ProdutoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        if (urlInformada.endsWith("_novo")) {
            request.setAttribute("acao", "incluir");
        } else {
            request.setAttribute("acao", "alterar");
            
            String inteiro = request.getParameter("id");
            int id = Integer.parseInt(inteiro);

            try {
                Produto p = service.select(id);
                request.setAttribute("produto", p);
                
            } catch (ProdutoException e) {
                // Se ocorrer erro, obtem a mensagem da exceção
                String msg = e.getMessage();
                request.setAttribute("msgErro", msg);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/produtos.jsp");
        dispatcher.forward(request, response);

    }
}
