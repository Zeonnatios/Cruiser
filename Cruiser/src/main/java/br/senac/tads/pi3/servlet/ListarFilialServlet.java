package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.model.Filial;
import br.senac.tads.pi3.controller.FilialService;
import br.senac.tads.pi3.exception.FiliaisException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "ListarFiliaisServlet", urlPatterns = {"/protegido/listar_filiais"})
public class ListarFilialServlet extends HttpServlet {

    private FilialService filial = new FilialService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/filiais.jsp");
        try {
            List<Filial> Filiais = filial.listarFilial();
            request.setAttribute("listarFiliais", Filiais);
            //Os dados contidos nos objetos do método listarFiliais
            //são passados a página jsp através do setAttribute
        } catch (FiliaisException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/listar_filiais.jsp").forward(request, response);
    }

}
