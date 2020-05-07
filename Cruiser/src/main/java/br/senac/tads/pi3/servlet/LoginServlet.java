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
        String emailStr = request.getParameter("inputEmail");
        String senhaStr = request.getParameter("inputPassword");

        boolean temErros = false;

        if (senhaStr == null || senhaStr.trim().length() < 1 || senhaStr.length() > 10) {
            temErros = true;
            request.setAttribute("erroSenha", "Senha inválida!");
        }

        // USAR PARA TESTES DE ACESSO À HOME SENHA 123 LOGIN ADMIN@ADMIN.COM
        if (senhaStr.equals("123") && emailStr.equals("admin@admin.com")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        if (emailStr == null || emailStr.trim().length() < 1) {
            temErros = true;
            request.setAttribute("erroEmail", "E-mail inválido!");
        } else {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; //-----------O ERRO DE AVISO DE EMAIL ESTA AQUI -------
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailStr);
            if (matcher.matches() == true) {
                temErros = true;
                request.setAttribute("erroEmail", "E-mail inválidoooo!");
            } else {
                Funcionario funcionario = new Funcionario();
                funcionario.setEmail(emailStr);
                funcionario.setSenha(senhaStr);
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                Funcionario autenticado = null;

                try {
                    autenticado = funcionarioDao.autenticar(funcionario);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (autenticado == null) {
                    temErros = true;
                    request.setAttribute("erroEmail", "E-mail não cadastrado!");
                    request.setAttribute("erroSenha", "Senha não cadastrada!");
                } else {
                    if (!autenticado.getEmail().equals(emailStr)) {
                        temErros = true;
                        request.setAttribute("erroEmail", "E-mail inválido!");
                    }
                    if (!autenticado.getSenha().equals(senhaStr)) {
                        temErros = true;
                        request.setAttribute("erroSenha", "Senha inválida!");
                    }
                    if (autenticado.getStatus() == false) {
                        temErros = true;
                        request.setAttribute("erroEmail", "Usuário desativado!");
                    }
                }
            }
        }
        if (temErros) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);
        }
    }
}
