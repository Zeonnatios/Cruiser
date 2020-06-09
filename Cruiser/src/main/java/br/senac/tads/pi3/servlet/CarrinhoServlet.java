package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ClienteService;
import br.senac.tads.pi3.controller.ProdutoService;
import br.senac.tads.pi3.exception.ClienteException;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Cliente;
import br.senac.tads.pi3.model.Funcionario;
import br.senac.tads.pi3.model.Produto;
import br.senac.tads.pi3.model.Venda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/protegido/carrinho"})
public class CarrinhoServlet extends HttpServlet {

    private ProdutoService produto = new ProdutoService();
    private ClienteService cliente = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("f");

        //Listagem de produtos na Model
        try {
            List<Produto> Produtos = produto.listarProdutoEstoque(f.getIdLoja());
            request.setAttribute("listarProdutos", Produtos);
            //Os dados contidos nos objetos do método listarProdutos
            //são passados a página jsp através do setAttribute
        } catch (ProdutoException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        //Listagem de clientes na Model
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("comand").equals("add")) {
            HttpSession sessao = request.getSession();

            // Verifica se já existe atributo itensCarrinho na sessao
            // Se nao existir cria um novo
            if (sessao.getAttribute("itensCarrinho") == null) {
                sessao.setAttribute("itensCarrinho", new ArrayList<Produto>());
            }

            if (sessao.getAttribute("cliente") == null) {
                sessao.setAttribute("cliente", new Cliente());

            }

            // Recupera a lista de itens selecionados da sessao
            ArrayList<Produto> itensCarrinho = (ArrayList<Produto>) sessao.getAttribute("itensCarrinho");
            Cliente c = (Cliente) sessao.getAttribute("cliente");

            request.setCharacterEncoding("UTF-8");
            String idProduto = request.getParameter("idProduto");
            String nomeP = request.getParameter("nomeProd");
            String qtdeP = request.getParameter("quantidadeProd");
            String precoProd = request.getParameter("precoProd");

            String idCliente = request.getParameter("idCliente");
            String nomeCli = request.getParameter("nomeCli");
            String cpfCli = request.getParameter("cpfCli");
            c.setIdCliente(Integer.parseInt(idCliente));
            c.setNome(nomeCli);
            c.setCpf(cpfCli);

            double total = Integer.parseInt(qtdeP) * Double.parseDouble(precoProd);
            Produto prod = new Produto();
            prod.setIdProduto(Integer.parseInt(idProduto));
            prod.setNome(nomeP);
            prod.setQuantidade(Integer.parseInt(qtdeP));
            prod.setPreco(Double.parseDouble(precoProd));
            prod.setTotal(total);
            itensCarrinho.add(prod);

            Venda carrinho = new Venda();
            carrinho.setProduto(itensCarrinho);

            System.out.println("ID: " + idProduto + " nome: " + nomeP + " qtde: " + qtdeP + " Preco: " + precoProd + " Total: " + total);

            response.sendRedirect(request.getContextPath() + "/protegido/carrinho");
        }
    }

}
