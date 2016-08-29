
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarAtendenteBo {
    
    public void cadastrar(Funcionario funcionario){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().adicionar(funcionario);
    }
}
