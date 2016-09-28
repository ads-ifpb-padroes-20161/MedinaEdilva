
package br.edu.ifpb.padroes.projeto.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class PegaPaciente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String cpfPac = request.getParameter("cpf");
        try {
            request.setAttribute("cpfPac", cpfPac);
            request.getRequestDispatcher("agendarConsulta.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PegaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
