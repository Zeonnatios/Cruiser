package br.senac.tads.pi3.servlet;

/*VERIFICAR O RETORNO DAS MENSAGENS DE ERRO
  VERIFICAR O DISPATCHER.FORWARD
  VERIFICAR MATCHER*/
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("inputEmail");
        String senha = request.getParameter("inputPassword");
        String msgErro;
        Funcionario autenticado = null;

        if (senha == null || senha.length() < 10) {
            msgErro = "Senha inválida!";
            request.setAttribute("Senha inválida", msgErro);
        } else {
            if (email != null && email.length() > 0) {
                String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    msgErro = "Email inválida!";
                    request.setAttribute("Email inválido", msgErro);
                } else {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setEmail(email);
                    funcionario.setSenha(senha);
                    FuncionarioDao funcionarioDao = new FuncionarioDao();

                    try {
                        autenticado = funcionarioDao.autenticar();
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (autenticado != null) {
                        if (autenticado.getEmail().equals(email) && autenticado.getSenha().equals(senha) && autenticado.getStatus() == true) {
                            //   HttpSession sessao = request.getSession();
                            //   sessao.setAttribute("Usuário Autenticado", autenticado);
                            //   sessao.setMaxInactiveInterval(10000); 
                            //   request.getRequestDispatcher("home.jsp").forward(request, response);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
                            dispatcher.forward(request, response);
                        }
                    } else {
                        msgErro = "Usuário inválido!";
                        request.setAttribute("Usuário inválido", msgErro);
                    }
                }
            }
        }
    }
}
