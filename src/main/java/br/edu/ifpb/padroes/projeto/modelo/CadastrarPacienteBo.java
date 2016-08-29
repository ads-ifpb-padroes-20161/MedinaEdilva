
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarPacienteBo {
    
    public void cadastrar(Pessoa pessoa){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().adicionar(pessoa);
    }
}
