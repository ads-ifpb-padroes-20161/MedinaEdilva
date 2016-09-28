
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class RemoverBo {
    
    public boolean removerAtendente(String cpf) {
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaFuncionario().remover(cpf);
    }
    
    public boolean removerMedico(String cpf) {
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().remover(cpf);
    }
    
    public boolean removerPaciente(String cpf) {
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaPessoa().remover(cpf);
    }
}
