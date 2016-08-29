
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.modelo.LoginBo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edilva
 */
public class LogarFuncionario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessao = request.getSession();
        
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        
        LoginBo login = new LoginBo();
        Funcionario funcionario = login.loginFuncionario(matricula, senha);
        
        
        if (funcionario == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Email ou senha incorretos!");
                request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("funcionario", funcionario);
            try {
                request.getRequestDispatcher("paginaDoAtendente.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
