
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class LoginBo {
    
    public Funcionario loginFuncionario(String matricula, String senha){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().login(matricula, senha);
    }
    
    public Medico loginMedico(String matricula, String senha){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().login(matricula, senha);
    }
}
