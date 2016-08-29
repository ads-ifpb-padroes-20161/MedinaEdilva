
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarPacientesBo {
 
    public List<Pessoa> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().buscarTodos();
    }
}
