
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarMedicoBo;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edilva
 */
public class CadastrarMedico implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        Medico medico = dadosDoMedico(request);
        CadastrarMedicoBo cadastro = new CadastrarMedicoBo();
        cadastro.cadastrar(medico);
        request.setAttribute("pagina", "cadastroMedico.jsp");
        if (medico == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar medico!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("medico", medico);
            try {
                request.setAttribute("mensagem", "Medico cadastrado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Medico dadosDoMedico(HttpServletRequest request) {
        Medico medico = new Medico();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            medico.setNome(nome);
        }
        
        if (request.getParameter("data") != null) {
            LocalDate dataNasc = LocalDate.parse(request.getParameter("data"));
            medico.setDataNasc(dataNasc);
        }
        
        if (request.getParameter("rg") != null) {
            String rg = request.getParameter("rg");
            medico.setRg(rg);
        }
        
        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            medico.setCpf(cpf);
        }
        
        if (request.getParameter("cnpj") != null) {
            String cnpj = request.getParameter("cnpj");
            medico.setCnpjClinica(cnpj);
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
            medico.setEmail(email);
        }
        
        if (request.getParameter("matricula") != null) {
            String matricula = request.getParameter("matricula");
            medico.setMatricula(matricula);
        }
        
        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            medico.setSenha(senha);
        }
        
        if (request.getParameter("crm") != null) {
            String crm = request.getParameter("crm");
            medico.setCrm(crm);
        }
        
        if (request.getParameter("especialidade") != null) {
            String especialidade = request.getParameter("especialidade");
            medico.setEspecialidade(especialidade);
        }
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        medico.setEndereco(endereco);
        medico.setTelefones(lista);
        
        return medico;
    }
    
}
