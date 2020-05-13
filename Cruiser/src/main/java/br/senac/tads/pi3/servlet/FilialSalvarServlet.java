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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "FilialSalvarServlet", urlPatterns = {"/filial_salvar", "/filial_update"})
public class FilialSalvarServlet extends HttpServlet {

    private FilialService service = new FilialService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        //ABRE FORM PARA CADASTRAR
        if (urlInformada.endsWith("_salvarfilial")) {
            request.setCharacterEncoding("UTF-8");
            String cidade = request.getParameter("txtCidade");
            String telefone = request.getParameter("txtTelefone");
            String tipo = request.getParameter("txtTipo");

            Filial f = new Filial();

            f.setCidade(cidade);
            f.setTelefone(telefone);
            f.setTipo(tipo);

            HttpSession sessao = request.getSession();

            try {
                service.inserirFilial(f);
                sessao.setAttribute("msgSucesso", "Filial cadastrado com sucesso");
            } catch (FiliaisException ex) {
                sessao.setAttribute("msgErro", "Erro ao cadastrar Filial - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_filiais");

        } else if (urlInformada.endsWith("_update")) {
            //ABRE FORM POPUALDO PARA EDITAR, FALTANTE SELECIONAR OS OPTIONS DOS SELECTS NO JSP
            request.setCharacterEncoding("UTF-8");

            //NO JSP SE USAR O DISABLED NO INPUT DE ID, O JSP MANDA PARA O SERVLET O ID COMO NULL
            //VINDO O ID COMO NULL NÃO É POSSIVEL FAZER UPDATE...
            //ENTÃO COM UM INPUT HIDDEN É POSSIVEL PEGAR O ID
            String id = request.getParameter("txtID");
            String cidade = request.getParameter("txtCidade");
            String telefone = request.getParameter("txtTelefone");
            String tipo = request.getParameter("txtTipo");

            Filial f = new Filial();

            f.setIdFilial(Integer.parseInt(id));
            f.setCidade(cidade);
            f.setTelefone(telefone);
            f.setTipo(tipo);

            HttpSession sessao = request.getSession();

            try {
                service.editarFilial(f);
                sessao.setAttribute("msgSucesso", "Filial editado com sucesso");
            } catch (FiliaisException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Filial - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_filiais");
        }

    }

}
