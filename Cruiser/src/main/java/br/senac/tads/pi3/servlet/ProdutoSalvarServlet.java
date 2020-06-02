package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Funcionario;
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
 * @author Cruiser
 */
@WebServlet(name = "ProdutoSalvarServlet", urlPatterns = {"/protegido/produto_salvar", "/protegido/produto_update"})
public class ProdutoSalvarServlet extends HttpServlet {

    private ProdutoService service = new ProdutoService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        if (urlInformada.endsWith("_salvar")) {

            HttpSession sessao = request.getSession();
            Funcionario f = (Funcionario) sessao.getAttribute("f");

            request.setCharacterEncoding("UTF-8");
            String nome = request.getParameter("nome");
            String quantidade = request.getParameter("quantidade");
            String preco = request.getParameter("preco");

            Produto p = new Produto();
            p.setNome(nome);
            p.setQuantidade(Integer.parseInt(quantidade));
            p.setPreco(Double.parseDouble(preco));
            p.setDisponivel(true);
            p.setIdLoja(f.getIdLoja());

            try {
                service.inserirProduto(p);
                sessao.setAttribute("msgSucesso", "Produto - " + p.getNome() + " cadastrado com sucesso!");
            } catch (Exception ex) {
                sessao.setAttribute("msgErro", "Erro ao cadastrar Produto: " + p.getNome() + " - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/protegido/listar_produtos");

        } else if (urlInformada.endsWith("_update")) {
            HttpSession sessao = request.getSession();
            Funcionario f = (Funcionario) sessao.getAttribute("f");

            request.setCharacterEncoding("UTF-8");
            String idProduto = request.getParameter("id");
            String nome = request.getParameter("nome");
            String quantidade = request.getParameter("quantidade");
            String preco = request.getParameter("preco");

            Produto p = new Produto();
            p.setIdProduto(Integer.parseInt(idProduto));
            p.setNome(nome);
            p.setQuantidade(Integer.parseInt(quantidade));
            p.setPreco(Double.parseDouble(preco));
            p.setDisponivel(true);
            p.setIdLoja(f.getIdLoja());

            try {
                service.editarProduto(p);
                sessao.setAttribute("msgSucesso", "Produto - " + p.getNome() + " atualizado com sucesso!");
            } catch (ProdutoException ex) {
                sessao.setAttribute("msgErro", "Erro ao atualizar dados do Produto " + p.getNome() + " - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/protegido/listar_produtos");
        }
    }
}
