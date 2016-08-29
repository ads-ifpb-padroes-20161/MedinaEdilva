
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class RemoverAtendenteBo {
    public boolean remover(String cpf) {
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().remover(cpf);
    }
}
