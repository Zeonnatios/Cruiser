/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.model.Filial;
import br.senac.tads.pi3.controller.FilialService;
import br.senac.tads.pi3.exception.FiliaisException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "FilialFormServlet", urlPatterns = {"/protegido/filial_novo", "/protegido/filial_editar"})
public class FilialFormServlet extends HttpServlet {

    private FilialService service = new FilialService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();
        if (urlInformada.endsWith("_novo")) {
            // Significa que usuário está abrindo formulário para inclusão.
            request.setAttribute("acao", "incluir");
        } else if (urlInformada.endsWith("_editar")) {

            // Significa que usuário está abrindo formulário para edição.
            request.setAttribute("acao", "alterar");
            //Recebemos o id pelo botão clicado e dps convertemso em string
            int id = Integer.parseInt(request.getParameter("id"));
            //Consultar o contato pelo ID e levar para JSP com o request.setAttribute
            try {
                Filial f = service.select(id);
                String status = "";

                request.setAttribute("filial", f);
            } catch (FiliaisException e) {
                // Se ocorrer erro, obtem a mensagem da exceção
                String msg = e.getMessage();
                request.setAttribute("msgErro", msg);
            }

        }

        request.getRequestDispatcher("/WEB-INF/jsp/filiais.jsp").forward(request, response);
    }

}
