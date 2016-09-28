/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RealizarConsulta implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ConsultaDao dao = new ConsultaDao();
        request.setAttribute("pagina", "consultasMedicoAgendada.jsp");
        if (!dao.realizarConsulta(id)) {
            try {
                request.setAttribute("mensagem", "Erro ao realizar consulta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RealizarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.getRequestDispatcher("consultasMedicoAgendada.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RealizarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
