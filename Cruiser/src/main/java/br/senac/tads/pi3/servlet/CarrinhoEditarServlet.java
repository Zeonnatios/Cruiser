package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CRUISER
 */
@WebServlet(name = "CarrinhoEditarServlet", urlPatterns = {"/protegido/carrinho_editar", "/protegido/carrinho_excluir"})
public class CarrinhoEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String urlInformada = request.getRequestURI();
        if (urlInformada.endsWith("_excluir")) {

            // Recupera a lista de itens selecionados da sessao para remover do carrinho de compras
            List<Produto> itensCarrinho = (List<Produto>) sessao.getAttribute("itensCarrinho");
            int id = Integer.parseInt(request.getParameter("id"));

            for (int i = 0; i < itensCarrinho.size(); i++) {
                if (itensCarrinho.get(i).getIdProduto() == id) {
                    itensCarrinho.remove(i);
                }
            }
        } else if (urlInformada.endsWith("_editar")) {

        }

        response.sendRedirect(request.getContextPath() + "/protegido/carrinho");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
