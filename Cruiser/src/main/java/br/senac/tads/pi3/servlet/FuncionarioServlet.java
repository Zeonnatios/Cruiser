
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.FuncionarioService;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionario/salvar"})
public class FuncionarioServlet extends HttpServlet {

    private FuncionarioService service = new FuncionarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idFuncionario = request.getParameter("idFuncionario");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String departamento = request.getParameter("departamento");
        String status = request.getParameter("status");

        Funcionario f = new Funcionario();
        f.setIdFuncionario(Integer.parseInt(idFuncionario));
        f.setNome(nome);
        f.setEmail(email);
        f.setEmail(email);
        f.setSenha(senha);
        f.setCidade(cidade);
        f.setDepartamento(departamento);
        f.setStatus(true);
        HttpSession sessao = request.getSession();

        try {
            service.inserirFuncionario(f);
            sessao.setAttribute(null, "Funcionario salvo com sucesso");
        } catch (Exception ex) {
            sessao.setAttribute(null, "Erro ao salvar Funcionario - " + ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/listar_funcionarios");

    }

}
