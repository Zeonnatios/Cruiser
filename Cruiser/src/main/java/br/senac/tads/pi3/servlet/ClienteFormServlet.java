/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ClienteService;
import br.senac.tads.pi3.exception.ClienteException;
import br.senac.tads.pi3.model.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/protegido_cliente_novo", "/protegido_cliente_editar"})
public class ClienteFormServlet extends HttpServlet {

    private ClienteService service = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();
        if (urlInformada.endsWith("_novo")) {
            // Significa que usuário está abrindo formulário para inclusão.
            request.setAttribute("acao", "incluir");
        } else {
            // Significa que usuário está abrindo formulário para edição.
            request.setAttribute("acao", "alterar");
            //Recebemos o id pelo botão clicado e dps convertemos em String
            int id = Integer.parseInt(request.getParameter("id"));
            //Consultar o contato pelo ID e levar para JSP com o request.setAttribute
            try {
                Cliente c = service.select(id);
                
                request.setAttribute("cliente", c);
                
            } catch (ClienteException e) {
                // Se ocorrer erro, obtem a mensagem da exceção
                String msg = e.getMessage();
                request.setAttribute("msgErro", msg);
            }

        }

        request.getRequestDispatcher("/WEB-INF/jsp/cliente.jsp").forward(request, response);
    }
 
}
