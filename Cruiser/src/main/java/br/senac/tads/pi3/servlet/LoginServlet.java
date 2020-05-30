package br.senac.tads.pi3.servlet;

import br.senac.tads.pi3.dao.FuncionarioDao;
import br.senac.tads.pi3.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        // USUÁRIO JÁ ESTÁ LOGADO E ACESSA DIRETAMENTE A HOME
        if (sessao.getAttribute("funcionario") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        //RECUPERANDO DADOS DO JSP
        String emailStr = request.getParameter("inputEmail");
        String senhaStr = request.getParameter("inputPassword");

        //VALIDANDO OS DADOS
        boolean temErros = false;
        boolean estaVazio = false;

        if (senhaStr == null || senhaStr.trim().length() < 1 || senhaStr.length() > 10) {
            estaVazio = true;
            request.setAttribute("erroSenha", "Senha inválida!");
        }

        if (emailStr == null || emailStr.trim().length() < 1) {
            estaVazio = true;
            request.setAttribute("erroEmail", "E-mail inválido!");
        }

        if (estaVazio) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

        if (emailStr != null && emailStr.trim().length() > 1) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailStr);
            if (matcher.matches() == false) {
                temErros = true;
                request.setAttribute("erroEmail", "Não é um e-mail válido!");
            } else {
                Funcionario funcionario = new Funcionario();
                funcionario.setEmail(emailStr);
                FuncionarioDao funcionarioDao = new FuncionarioDao();

                try {
                    Funcionario autenticado = funcionarioDao.autenticar(funcionario);

                    if (autenticado.getEmail() == null) {
                        temErros = true;
                        request.setAttribute("erroEmail", "Usuário não cadastrado!");
                    } else {
                        if (!autenticado.getSenha().equals(senhaStr)) {
                            temErros = true;
                            request.setAttribute("erroSenha", "Senha incorreta!");
                        }
                        if (autenticado.getStatus() == false) {
                            temErros = true;
                            request.setAttribute("erroEmail", "Usuário desativado!");
                        }
                        if (autenticado.getSenha().equals(senhaStr) && autenticado.getStatus() == true) {
                            HttpSession sessao = request.getSession();
                            sessao.setAttribute("f", autenticado);                            
                            response.sendRedirect(request.getContextPath() + "/home");
                            return;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (temErros) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        } 
    }
}
