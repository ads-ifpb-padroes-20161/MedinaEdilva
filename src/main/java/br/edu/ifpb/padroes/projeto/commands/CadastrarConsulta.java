
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.dao.ConsultaDao;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.entidades.StatusConsulta;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarBo;
import br.edu.ifpb.padroes.projeto.modelo.ExibirBo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class CadastrarConsulta implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Consulta consulta = dadosDaConsulta(request);
        //CadastrarBo cadastro = new CadastrarBo();
        ConsultaDao dao = new ConsultaDao();
        request.setAttribute("pagina", "agendarConsulta.jsp");
        if (!dao.adicionar(consulta)) {
            try {
                request.setAttribute("mensagem", "Erro ao agendar consulta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Consulta agendada com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Consulta dadosDaConsulta(HttpServletRequest request) {
        Consulta consulta = new Consulta();
        ExibirBo ex = new ExibirBo();
        
        if (request.getParameter("cpfPac") != null) {
            String cpfPac = request.getParameter("cpfPac");
            Pessoa paciente = ex.exibirPaciente(cpfPac);
            consulta.setPaciente(paciente);
        }
        
        if (request.getParameter("medico") != null) {
            String cpfMed = request.getParameter("medico");
            Medico medico = ex.exibirMedico(cpfMed);
            consulta.setMedico(medico);
        }
        
        if (request.getParameter("data") != null) {
            LocalDate data = LocalDate.parse(request.getParameter("data"));
            consulta.setData(data);
        }
        
        if (request.getParameter("hora") != null) {
            LocalTime hora = LocalTime.parse(request.getParameter("hora"));
            consulta.setHora(hora);
        }
        
        if (request.getParameter("valor") != null) {
            double valor = Double.parseDouble(request.getParameter("valor"));
            consulta.setValor(valor);
        }
        
        consulta.setStatus(StatusConsulta.AGENDADA);
        
        HttpSession sessao = request.getSession();
        Funcionario atendente = (Funcionario) sessao.getAttribute("atendente");
        consulta.setAtendente(atendente);
        
        return consulta;
    }
}
