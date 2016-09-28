
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
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
public class ExibirAtendente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        String cpf = request.getParameter("cpf");
        ExibirBo exibi = new ExibirBo();
        Funcionario atendente = exibi.exibirAtendente(cpf);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if (atendente != null) {
                request.setAttribute("atendente", atendente);
                request.getRequestDispatcher("detalhesDoAtendente.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Atendente não encontrado!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
