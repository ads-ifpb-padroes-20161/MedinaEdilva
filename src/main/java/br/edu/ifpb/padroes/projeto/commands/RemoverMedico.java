
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.modelo.RemoverMedicoBo;
import br.edu.ifpb.padroes.projeto.modelo.RemoverPacienteBo;
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
public class RemoverMedico implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        String cpf = request.getParameter("cpf");
        RemoverMedicoBo remover = new RemoverMedicoBo();
        request.setAttribute("pagina", "listaDeMedicos.jsp");
        if (remover.remover(cpf)) {
            try {
                request.setAttribute("mensagem", "Medico removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro na remoção do medico!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
