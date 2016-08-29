
package br.edu.ifpb.padroes.projeto.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Edilva
 */
public interface ConexaoIF {
    
    public Connection getConnection();
    
    public void desconecta(Statement st) throws DataBaseException;
    
    public void desconecta(PreparedStatement st) throws DataBaseException;
}
