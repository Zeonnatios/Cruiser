package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.exception.ClienteException;

import br.senac.tads.pi3.controller.ClienteService;
import br.senac.tads.pi3.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ListarClientesServlet", urlPatterns = {"/listar_clientes"})
public class ListarClienteServlet extends HttpServlet {

    private ClienteService cliente = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        request.getRequestDispatcher("/WEB-INF/jsp/listar_clientes.jsp").forward(request, response);

    }

}
