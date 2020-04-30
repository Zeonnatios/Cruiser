package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.exception.ClienteException;

import br.senac.tads.pi3.exception.ClienteService;
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
@WebServlet(name = "ClientesServlet", urlPatterns = {"/clientes"})
public class ClientesServlet extends HttpServlet {

    ClienteService cliente = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Cliente> clientes = cliente.listarCliente();
            request.setAttribute("listaContatos", clientes);
        } catch (ClienteException e) {
            // Se ocorrer erro, obtem a mensagem da exceção

            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/clientes.jsp").forward(request, response);

    }

}
