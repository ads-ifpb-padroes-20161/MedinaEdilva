package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
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
public class ExibirClinica implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        String cnpj = request.getParameter("cnpj");
        ExibirBo exibi = new ExibirBo();
        Clinica clinica = exibi.exibirClinica(cnpj);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if (clinica != null) {
                request.setAttribute("clinica", clinica);
                request.getRequestDispatcher("detalhesDaClinica.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Clínica não encontrada!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
