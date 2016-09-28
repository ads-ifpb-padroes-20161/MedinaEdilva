

package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarBo {
    
    public List<Clinica> listarClinica(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClinica().listarClinica();
    }
    
    public List<Medico> listarMedico(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().buscarTodos();
    }
    
    public List<Pessoa> listarPaciente(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().buscarTodos();
    }
    
    public List<Funcionario> listarAtendente(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().buscarTodos();
    }
    
    public List<Consulta> listarConsulta(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConsulta().buscarTodos();
    }
}
