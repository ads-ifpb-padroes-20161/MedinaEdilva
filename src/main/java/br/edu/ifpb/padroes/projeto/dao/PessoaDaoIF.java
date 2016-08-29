
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface PessoaDaoIF {
    
    public boolean adicionar(Pessoa pessoa);

    public boolean atualizar(Pessoa pessoa, String cpf);

    public boolean remover(String cpf);

    public Pessoa buscarPorCpf(String cpf);

    public List<Pessoa> buscarTodos();
    
}
