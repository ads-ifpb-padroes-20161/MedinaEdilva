package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.modelo.RemoverBo;
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
public class RemoverClinica implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String cpf = request.getParameter("cnpj");
        RemoverBo remover = new RemoverBo();
        request.setAttribute("pagina", "listaDeClinicas.jsp");
        if (remover.removerMedico(cpf)) {
            try {
                request.setAttribute("mensagem", "Clinica removida com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RemoverClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Clinica não pode ser removida!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RemoverClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
