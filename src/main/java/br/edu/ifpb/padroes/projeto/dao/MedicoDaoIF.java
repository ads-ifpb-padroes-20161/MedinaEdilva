
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Medico;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface MedicoDaoIF {
    
    public boolean adicionar(Medico medico);

    public boolean atualizar(Medico medico, String cpf);

    public boolean remover(String cpf);

    public Medico buscarPorCpf(String cpf);

    public List<Medico> buscarTodos();
    
    public Medico login(String matricula, String senha);
}
