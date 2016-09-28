
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarBo {
    
    public boolean cadastrarAtendente(Funcionario funcionario){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().adicionar(funcionario);
    }
    
    public boolean cadastrarClinica(Clinica clinica){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClinica().adicionar(clinica);
    }
    
    public boolean cadastrarMedico(Medico medico){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().adicionar(medico);
    }
    
    public boolean cadastrarPaciente(Pessoa pessoa){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().adicionar(pessoa);
    }
    
    public boolean cadastrarConsulta(Consulta consulta){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConsulta().adicionar(consulta);
    }
}
