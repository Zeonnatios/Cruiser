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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cruiser
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/produto_salvar", "/produto_update"})
public class ProdutoSalvarServlet extends HttpServlet {

    private ProdutoService service = new ProdutoService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        if (urlInformada.endsWith("_salvar")) {
            request.setCharacterEncoding("UTF-8");
            String nome = request.getParameter("nome");
            String quantidade = request.getParameter("quantidade");
            String preco = request.getParameter("preco");
            //String categoria[] = request.getParameterValues("categoria");

            Produto p = new Produto();
            p.setNome(nome);
            p.setQuantidade(Integer.parseInt(quantidade));
            p.setPreco(Double.parseDouble(preco));
            p.setDisponivel(true);
//            for (int i = 0; i < categoria.length; i++) {
//                if (categoria[i] != null) {
//                    //p.setCategoria(categoria[i]);
//                }
//            }
            
            HttpSession sessao = request.getSession();

            try {
                service.inserirProduto(p);
                sessao.setAttribute("msgSucesso", "Produto salvo com sucesso");
            } catch (Exception ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Produto - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_produtos");
            
        } else if (urlInformada.endsWith("_update")) {
            request.setCharacterEncoding("UTF-8");
            String idProduto = request.getParameter("idProduto");
            String nome = request.getParameter("nome");
            String quantidade = request.getParameter("quantidade");
            String preco = request.getParameter("preco");
            //String categoria[] = request.getParameterValues("categoria");
            

            Produto p = new Produto();
            p.setIdProduto(Integer.parseInt(idProduto));
            p.setNome(nome);
            p.setQuantidade(Integer.parseInt(quantidade));
            p.setPreco(Double.parseDouble(preco));
            p.setDisponivel(true);
//            for (int i = 0; i < categoria.length; i++) {
//                if (categoria[i] != null) {
//                    //p.setCategoria(categoria[i]);
//                }
//            }
            
            HttpSession sessao = request.getSession();

            try {
                service.editarProduto(p);
                sessao.setAttribute("msgSucesso", "Produto editado com sucesso");
            } catch (ProdutoException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Produto - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_produtos");
        }
    }
}
