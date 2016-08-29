
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FuncionarioDaoIF {
    
    public boolean adicionar(Funcionario funcionario);

    public boolean atualizar(Funcionario funcionario, String cpf);

    public boolean remover(String cpf);

    public Funcionario buscarPorCpf(String cpf);

    public List<Funcionario> buscarTodos();
    
    public Funcionario login(String matricula, String senha);
    
}
