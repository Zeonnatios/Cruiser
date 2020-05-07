package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lukas
 */
@WebServlet(name = "ProdutoSalvar", urlPatterns = {"/produtos/salvar"})
public class ProdutoSalvar extends HttpServlet {

    private ProdutoService service = new ProdutoService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idProduto = request.getParameter("idProduto");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String preco = request.getParameter("preco");
        String categoria = request.getParameter("categoria");

        Produto p = new Produto();

        p.setIdProduto(Integer.parseInt(idProduto));
        p.setNome(nome);
        p.setQuantidade(Integer.parseInt(quantidade));
        p.setPreco(Float.parseFloat(preco));
        p.setCategoria(categoria);

        HttpSession sessao = request.getSession();
        try {
            service.inserirProduto(p);
            request.setAttribute("msgSucesso", "Produto salvo com sucesso!");

        } catch (Exception e) {
            request.setAttribute("msgErro", "Erro ao salvar - " + e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/produtos");
    }

}
