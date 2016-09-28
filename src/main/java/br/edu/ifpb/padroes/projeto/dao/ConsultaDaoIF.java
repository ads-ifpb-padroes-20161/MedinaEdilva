
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ConsultaDaoIF {
    
    public boolean adicionar(Consulta consulta);

    public boolean atualizar(Consulta consulta, int id);

    public boolean remover(int id);

    public Consulta buscarPorId(int id);

    public List<Consulta> buscarTodos();

    public List<Consulta> buscarPorPaciente(String cpf);
    
    public List<Consulta> buscarPorMedico(String cpf);
    
    public boolean cancelarConsulta(int id);
    
    public boolean realizarConsulta(int id);
    
}
