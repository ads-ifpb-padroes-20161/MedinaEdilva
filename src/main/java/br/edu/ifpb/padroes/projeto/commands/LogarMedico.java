
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Medico;
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
public class LogarMedico implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession sessao = request.getSession();
        
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        
        LoginBo login = new LoginBo();
        Medico medico = login.loginMedico(matricula, senha);
        
        
        if (medico == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Login ou senha incorretos!");
                request.getRequestDispatcher("erroLoginMedico.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("medico", medico);
            try {
                request.getRequestDispatcher("paginaDoMedico.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
