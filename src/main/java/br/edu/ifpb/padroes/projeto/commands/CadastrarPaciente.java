
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.entidades.TipoPessoa;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarBo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CadastrarPaciente implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Pessoa paciente = dadosDoPaciente(request);
        CadastrarBo cadastro = new CadastrarBo();
        request.setAttribute("pagina", "cadastroPaciente.jsp");
        if (!cadastro.cadastrarPaciente(paciente)) {
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar paciente!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Paciente cadastrado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Pessoa dadosDoPaciente(HttpServletRequest request) {
        Pessoa paciente = new Pessoa();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            paciente.setNome(nome);
        }
        
        if (request.getParameter("data") != null) {
            LocalDate dataNasc = LocalDate.parse(request.getParameter("data"));
            paciente.setDataNasc(dataNasc);
        }
        
        if (request.getParameter("rg") != null) {
            String rg = request.getParameter("rg");
            paciente.setRg(rg);
        }
        
        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            paciente.setCpf(cpf);
        }
        
        if (request.getParameter("estado") != null) {
            String estado = request.getParameter("estado");
            endereco.setEstado(estado);
        }
        
        if (request.getParameter("cidade") != null) {
            String cidade = request.getParameter("cidade");
            endereco.setCidade(cidade);
        }
        
        if (request.getParameter("bairro") != null) {
            String bairro = request.getParameter("bairro");
            endereco.setBairro(bairro);
        }
        
        if (request.getParameter("rua") != null) {
            String rua = request.getParameter("rua");
            endereco.setRua(rua);
        }
        
        if (request.getParameter("numero") != null) {
            String numero = request.getParameter("numero");
            endereco.setNumero(numero);
        }
        
        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            paciente.setEmail(email);
        }
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        paciente.setEndereco(endereco);
        paciente.setTelefones(lista);
        
        return paciente;
    }
    
}
