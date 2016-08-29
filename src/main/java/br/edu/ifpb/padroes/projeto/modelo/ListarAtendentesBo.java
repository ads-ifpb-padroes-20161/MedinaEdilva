
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarAtendentesBo {
    
    public List<Funcionario> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().buscarTodos();
    }
}
