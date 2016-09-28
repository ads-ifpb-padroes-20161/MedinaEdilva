
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExibirBo {
    
    public Pessoa exibirPaciente(String cpf){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().buscarPorCpf(cpf);
    }
    
    public Funcionario exibirAtendente(String cpf){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().buscarPorCpf(cpf);
    }
    
    public Medico exibirMedico(String cpf){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().buscarPorCpf(cpf);
    }
    
    public Clinica exibirClinica(String cnpj){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClinica().exibir(cnpj);
    }
}
