
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
public class LogarAtendente implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession sessao = request.getSession();
        
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        
        LoginBo login = new LoginBo();
        Funcionario atendente = login.loginFuncionario(matricula, senha);
        
        
        if (atendente == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Login ou senha incorretos!");
                request.getRequestDispatcher("erroLoginAtendente.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("atendente", atendente);
            try {
                request.getRequestDispatcher("paginaDoAtendente.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
