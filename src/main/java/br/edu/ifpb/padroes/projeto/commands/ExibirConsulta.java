
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.dao.ConsultaDao;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class ExibirConsulta implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("id"));
        ConsultaDao dao = new ConsultaDao();
        Consulta consulta = dao.buscarPorId(id);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if(consulta != null){
                request.setAttribute("consulta", consulta);
                request.getRequestDispatcher("detalhesDaConsulta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Erro ao exibir detalhes da consulta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
