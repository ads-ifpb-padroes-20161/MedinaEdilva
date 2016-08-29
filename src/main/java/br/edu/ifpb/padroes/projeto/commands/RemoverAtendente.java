
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.modelo.RemoverAtendenteBo;
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
public class RemoverAtendente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        String cpf = request.getParameter("cpf");
        RemoverAtendenteBo remover = new RemoverAtendenteBo();
        request.setAttribute("pagina", "listaDeAtendentes.jsp");
        if (remover.remover(cpf)) {
            try {
                request.setAttribute("mensagem", "Atendente removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro na remoção do atendente!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
