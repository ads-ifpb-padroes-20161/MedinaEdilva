
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarMedicosBo {
    
    public List<Medico> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().buscarTodos();
    }
}
