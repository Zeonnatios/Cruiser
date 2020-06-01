package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ClienteService;
import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.dao.VendasDao;
import br.senac.tads.pi3.exception.ClienteException;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Cliente;
import br.senac.tads.pi3.model.Produto;
import br.senac.tads.pi3.model.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/protegido_carrinho"})
public class CarrinhoServlet extends HttpServlet {

    private ProdutoService produto = new ProdutoService();
    private ClienteService cliente = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession sessao = request.getSession();
//        Vector carrinho = (Vector) sessao.getAttribute("carrinho");
//
//        if (carrinho == null) {
//            carrinho = new Vector();
//            sessao.setAttribute("carrinho", carrinho);
//        }
//        String idProduto = request.getParameter("idProduto");
//        String nome = request.getParameter("nome");
//        String quantidade = request.getParameter("quantidade");
//        String idCliente = request.getParameter("idCliente");
//        String nomeCli = request.getParameter("nomeCli");
//        String cpfCli = request.getParameter("cpfCli");
//
//        Venda v = new Venda();
//        Produto p = new Produto();
//        Cliente c = new Cliente();
//        p.setIdProduto(Integer.parseInt(idProduto));
//        p.setNome(nome);
//        v.setProduto(p);
//        c.setIdCliente(Integer.parseInt(idCliente));
//        c.setNome(nomeCli);
//        c.setCpf(cpfCli);
//        v.setCliente(c);
//
//        if (p.equals(p) && c.equals(c)) {
//            VendasDao dao = new VendasDao();
//            try {
//                dao.inserirItem(v);
//            } catch (SQLException ex) {
//                Logger.getLogger(CarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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
        try {
            List<Cliente> clientes = cliente.listarCliente();
            request.setAttribute("listarClientes", clientes);
            //Os dados contidos nos objetos do método listarClientes
            //são passados a página jsp através do setAttribute
        } catch (ClienteException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/carrinho.jsp");
        dispatcher.forward(request, response);
    }

}
