package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.dao.VendasDao;
import br.senac.tads.pi3.model.Cliente;
import br.senac.tads.pi3.model.Produto;
import br.senac.tads.pi3.model.Venda;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/carrinho"})
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        Vector carrinho = (Vector) sessao.getAttribute("carrinho");
        
        if(carrinho == null){
            carrinho = new Vector();
            sessao.setAttribute("carrinho", carrinho);
        }
        String idProduto = request.getParameter("idProduto");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String idCliente = request.getParameter("idCliente");
        String nomeCli = request.getParameter("nomeCli");
        String cpfCli = request.getParameter("cpfCli");
        
        Venda v = new Venda();
        Produto p = new Produto();
        Cliente c = new Cliente();
        p.setIdProduto(Integer.parseInt(idProduto));
        p.setNome(nome);
        v.setProduto(p);
        c.setIdCliente(Integer.parseInt(idCliente));
        c.setNome(nomeCli);
        c.setCpf(cpfCli);
        v.setCliente(c);
            
        if(p.equals(p) && c.equals(c)){
            VendasDao dao = new VendasDao();
            try {
                dao.inserirItem(v);
            } catch (SQLException ex) {
                Logger.getLogger(CarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/carrinho.jsp");
        dispatcher.forward(request, response);
     }

}
