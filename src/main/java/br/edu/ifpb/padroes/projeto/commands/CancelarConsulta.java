
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.dao.ConsultaDao;
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
public class CancelarConsulta implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ConsultaDao dao = new ConsultaDao();
        request.setAttribute("pagina", "listaDeConsultas.jsp");
        if (!dao.cancelarConsulta(id)) {
            try {
                request.setAttribute("mensagem", "Erro ao cancelar consulta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CancelarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.getRequestDispatcher("listaDeConsultas.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CancelarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
