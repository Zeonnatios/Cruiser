/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.cruiser;

import br.senac.tads.pi3.dao.UsuarioDao;
import br.senac.tads.pi3.model.Usuario;
import java.io.IOException;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    private UsuarioDao dao;
    

    @Override
    public void init() {
        dao = new UsuarioDao();
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sessao = request.getParameter("sessao");
        if (sessao != null) {
            if (sessao.equals("CREATE")) {
                Usuario usuario = CriaUsuario(request);
                dao.inserirUsuario(usuario);
                request.setAttribute("mensagem", "Usuario salvo com sucesso");
            }
        }
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Usuario.jsp");
        dispatcher.forward(request, response);

    }

    private Usuario CriaUsuario(HttpServletRequest request) {

        String nomeUsuario = request.getParameter("nomeUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");
        String permissaoUsuario = request.getParameter("permissaoUsuario");

        Usuario usuario = new Usuario(nomeUsuario, senhaUsuario, permissaoUsuario);

        return usuario;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
