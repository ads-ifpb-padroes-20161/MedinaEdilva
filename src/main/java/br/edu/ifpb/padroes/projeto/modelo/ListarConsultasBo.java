
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarConsultasBo {
    
    public List<Consulta> listarConsulta(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConsulta().buscarTodos();
    }
}
