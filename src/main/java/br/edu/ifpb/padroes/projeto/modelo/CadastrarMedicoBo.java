
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;
import br.edu.ifpb.padroes.projeto.entidades.Medico;

/**
 *
 * @author Edilva
 */
public class CadastrarMedicoBo {
    
    public void cadastrar(Medico medico){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().adicionar(medico);
    }
}
