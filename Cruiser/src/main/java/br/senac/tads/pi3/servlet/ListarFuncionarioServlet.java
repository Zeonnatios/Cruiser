
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.FuncionarioService;
import br.senac.tads.pi3.exception.FuncionarioException;
import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukas
 */
@WebServlet(name = "ListarFuncionariosServlet", urlPatterns = {"/protegido_listar_funcionarios"})
public class ListarFuncionarioServlet extends HttpServlet {

    private FuncionarioService funcionario = new FuncionarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Funcionario> funcionarios = funcionario.listarFuncionarios();
            request.setAttribute("listarFuncionarios", funcionarios);
            //Os dados contidos nos objetos do método listarClientes
            //são passados a página jsp através do setAttribute
        } catch (FuncionarioException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/listar_funcionario.jsp").forward(request, response);

    }
}
