
package br.edu.ifpb.padroes.projeto.commands;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarBo;
import java.io.IOException;
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
public class CadastrarClinica implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Clinica clinica = dadosDaClinica(request);
        CadastrarBo cadastro = new CadastrarBo();
        request.setAttribute("pagina", "cadastroClinica.jsp");
        if (!cadastro.cadastrarClinica(clinica)) {
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar clinica!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Clinica cadastrada com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Clinica dadosDaClinica(HttpServletRequest request) {
        Clinica clinica = new Clinica();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            clinica.setNome(nome);
        }
        
        if (request.getParameter("cnpj") != null) {
            String cnpj = request.getParameter("cnpj");
            clinica.setCnpj(cnpj);
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
            clinica.setEmail(email);
        }
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        clinica.setEnderecoClinica(endereco);
        clinica.setTelefones(lista);
        
        return clinica;
    }
    
}
