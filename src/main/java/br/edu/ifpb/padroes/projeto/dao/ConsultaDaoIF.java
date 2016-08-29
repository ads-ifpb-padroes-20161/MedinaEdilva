
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ConsultaDaoIF {
    
    public boolean adicionar(Consulta consulta);

    public boolean atualizar(Consulta consulta, int codConsulta);

    public boolean remover(int codConsulta);

    public Consulta buscarPorId(int codConsulta);

    public List<Consulta> buscarTodos();

    public List<Consulta> buscarPorNome(String nome);
    
}
