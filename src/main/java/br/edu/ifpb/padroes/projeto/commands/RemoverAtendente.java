
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
public class RemoverAtendente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String cpf = request.getParameter("cpf");
        RemoverBo remover = new RemoverBo();
        request.setAttribute("pagina", "listaDeAtendentes.jsp");
        if (remover.removerAtendente(cpf)) {
            try {
                request.setAttribute("mensagem", "Atendente removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RemoverAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Erro na remoção do atendente!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RemoverAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
