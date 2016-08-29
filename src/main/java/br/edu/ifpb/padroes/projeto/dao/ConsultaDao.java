
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ConsultaDao implements ConsultaDaoIF {

    @Override
    public boolean adicionar(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Consulta consulta, int codConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int codConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta buscarPorId(int codConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
