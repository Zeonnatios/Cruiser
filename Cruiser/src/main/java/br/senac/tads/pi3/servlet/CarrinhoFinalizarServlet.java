package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.VendasService;
import br.senac.tads.pi3.exception.VendaException;
import br.senac.tads.pi3.model.Cliente;
import br.senac.tads.pi3.model.Produto;
import br.senac.tads.pi3.model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CRUSIER
 */
@WebServlet(name = "CarrinhoFinalizarServlet", urlPatterns = {"/protegido/finalizarVenda"})
public class CarrinhoFinalizarServlet extends HttpServlet {

    private VendasService service = new VendasService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        request.setCharacterEncoding("UTF-8");

        // Recupera a lista de itens selecionados da sessao
        ArrayList<Produto> itensCarrinho = (ArrayList<Produto>) sessao.getAttribute("itensCarrinho");
        Cliente c = (Cliente) sessao.getAttribute("cliente");

        double totalVenda = 0;
        for (int i = 0; i < itensCarrinho.size(); i++) {
            totalVenda += itensCarrinho.get(i).getTotal();
        }

        String idFuncionario = request.getParameter("sFuncionaioID");
        String idLoja = request.getParameter("sFuncionarioLoja");

        Venda v = new Venda();
        v.setIdCliente(c.getIdCliente());
        v.setIdFuncionario(Integer.parseInt(idFuncionario));
        v.setIdLoja(Integer.parseInt(idLoja));
        v.setValorTotal(totalVenda);
        LocalDate diaAtual = LocalDate.now();
        v.setDataVenda(diaAtual);
        v.setProduto(itensCarrinho);

        try {
            int estoque = 0;
            boolean flag = true;
            for (Produto p : itensCarrinho) {
                estoque = service.consultarEstoque(p.getIdProduto());
                if (estoque < p.getQuantidade()) {
                    sessao.setAttribute("msgErro", "Não é possível finalizar a venda. Produto: " + p.getNome() + " não possui estoque o suficiente!");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                service.inserirVenda(v);
                sessao.setAttribute("msgSucesso", "Venda realizada com sucesso!");
            }
        } catch (VendaException ex) {
            sessao.setAttribute("msgErro", "Erro ao finalizar venda - " + ex.getMessage());
        }
        c.setCpf(null);
        c.setEmail(null);
        c.setIdCliente(0);
        c.setNome(null);

        itensCarrinho.clear();
        response.sendRedirect(request.getContextPath() + "/protegido/carrinho");

    }

}
