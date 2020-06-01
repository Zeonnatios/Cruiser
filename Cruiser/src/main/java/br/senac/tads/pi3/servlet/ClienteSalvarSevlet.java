/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.controller.ClienteService;
import br.senac.tads.pi3.exception.ClienteException;
import br.senac.tads.pi3.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ClienteSalvarSevlet", urlPatterns = {"/cliente_salvar", "/cliente_update"})
public class ClienteSalvarSevlet extends HttpServlet {

      private ClienteService service = new ClienteService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlInformada = request.getRequestURI();

        //ABRE FORM PARA CADASTRAR
        if (urlInformada.endsWith("_salvar")) {
            request.setCharacterEncoding("UTF-8");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            

            
            Cliente c = new Cliente();
            c.setNome(nome);
            c.setCpf(cpf);
            c.setEmail(email);
            
            

            HttpSession sessao = request.getSession();

            try {
                service.inserirCliente(c);
                
                sessao.setAttribute("msgSucesso", "Cliente salvo com sucesso");
            } catch (ClienteException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Cliente - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_clientes");

        } else if (urlInformada.endsWith("_update")) {
            //ABRE FORM POPULADO PARA EDITAR, FALTANTE SELECIONAR OS OPTIONS DOS SELECTS NO JSP
            request.setCharacterEncoding("UTF-8");

            //NO JSP SE USAR O DISABLED NO INPUT DE ID, O JSP MANDA PARA O SERVLET O ID COMO NULL
            //VINDO O ID COMO NULL NÃO É POSSIVEL FAZER UPDATE...
            //ENTÃO COM UM INPUT HIDDEN É POSSIVEL PEGAR O ID
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            

            System.out.println(id + "\n" + nome + "\n" + cpf + "\n" + email + "\n");

            Cliente cli = new Cliente();
            cli.setIdCliente(Integer.parseInt(id));
            cli.setNome(nome);
            cli.setCpf(cpf);
            cli.setEmail(email);
            

            HttpSession sessao = request.getSession();

            try {
                service.editarCliente(cli);
                sessao.setAttribute("msgSucesso", "Cliente editado com sucesso");
            } catch (ClienteException ex) {
                sessao.setAttribute("msgErro", "Erro ao salvar Cliente - " + ex.getMessage());
            }
            response.sendRedirect(request.getContextPath() + "/listar_clientes");
        }

    }
}
