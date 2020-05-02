package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Produto;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListarProdutosServlet", urlPatterns = {"/listar_produtos"})
public class ListarProdutosServlet extends HttpServlet {

    private ProdutoService produto = new ProdutoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Produto> Produtos = produto.listarProduto();
            request.setAttribute("listarProdutos", Produtos);
            //Os dados contidos nos objetos do método listarProdutos
            //são passados a página jsp através do setAttribute
        } catch (ProdutoException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/listar_produtos.jsp").forward(request, response);

    }

}
