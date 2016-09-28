
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.modelo.ExibirBo;
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
public class ExibirMedico implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        String cpf = request.getParameter("cpf");
        ExibirBo exibi = new ExibirBo();
        Medico medico = exibi.exibirMedico(cpf);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if (medico != null) {
                request.setAttribute("medico", medico);
                request.getRequestDispatcher("detalhesDoMedico.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Médico não encontrado!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
