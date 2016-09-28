/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
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
public class ExibirPaciente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        String cpf = request.getParameter("cpf");
        ExibirBo exibi = new ExibirBo();
        Pessoa paciente = exibi.exibirPaciente(cpf);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if (paciente != null) {
                request.setAttribute("paciente", paciente);
                request.getRequestDispatcher("detalhesDoPaciente.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Paciente não encontrada!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

