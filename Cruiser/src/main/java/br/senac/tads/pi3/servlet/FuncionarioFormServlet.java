package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.FuncionarioService;
import br.senac.tads.pi3.exception.FuncionarioException;
import br.senac.tads.pi3.model.Filial;
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
 * @author Cruiser
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionario_novo", "/funcionario_editar"})
public class FuncionarioFormServlet extends HttpServlet {

    private FuncionarioService service = new FuncionarioService();

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
            //Recebemos o id pelo botão clicado e dps convertemso em string
            int id = Integer.parseInt(request.getParameter("id"));
            //Consultar o contato pelo ID e levar para JSP com o request.setAttribute
            try {
                Funcionario f = service.select(id);
                String status = "";

                if (f.getStatus() == true) {
                    status = "1";
                } else {
                    status = "2";
                }
                request.setAttribute("funcionario", f);
                request.setAttribute("status", status);
            } catch (FuncionarioException e) {
                // Se ocorrer erro, obtem a mensagem da exceção
                String msg = e.getMessage();
                request.setAttribute("msgErro", msg);
            }

        }

        request.getRequestDispatcher("/WEB-INF/jsp/funcionario.jsp").forward(request, response);
    }

}
