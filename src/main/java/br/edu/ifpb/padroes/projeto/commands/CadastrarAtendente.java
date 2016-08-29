
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarAtendenteBo;
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
public class CadastrarAtendente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        Funcionario funcionario = dadosDoAtendente(request);
        CadastrarAtendenteBo cadastro = new CadastrarAtendenteBo();
        cadastro.cadastrar(funcionario);
        request.setAttribute("pagina", "cadastroAtendente.jsp");
        if (funcionario == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar atendente!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("funcionario", funcionario);
            try {
                request.setAttribute("mensagem", "Atendente cadastrado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Funcionario dadosDoAtendente(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            funcionario.setNome(nome);
        }
        
        if (request.getParameter("data") != null) {
            LocalDate dataNasc = LocalDate.parse(request.getParameter("data"));
            funcionario.setDataNasc(dataNasc);
        }
        
        if (request.getParameter("rg") != null) {
            String rg = request.getParameter("rg");
            funcionario.setRg(rg);
        }
        
        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            funcionario.setCpf(cpf);
        }
        
        if (request.getParameter("cnpj") != null) {
            String cnpj = request.getParameter("cnpj");
            funcionario.setCnpjClinica(cnpj);
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
            funcionario.setEmail(email);
        }
        
        if (request.getParameter("matricula") != null) {
            String matricula = request.getParameter("matricula");
            funcionario.setMatricula(matricula);
        }
        
        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            funcionario.setSenha(senha);
        }
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        funcionario.setEndereco(endereco);
        funcionario.setTelefones(lista);
        
        return funcionario;
    }
}
