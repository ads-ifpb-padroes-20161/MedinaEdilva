
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarClinicaBo {
    
    public List<Clinica> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaClinica().listarClinica();
    }
}
