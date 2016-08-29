
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarClinicaBo {
    
    public void cadastrar(Clinica clinica){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaClinica().adicionar(clinica);
    }
}
