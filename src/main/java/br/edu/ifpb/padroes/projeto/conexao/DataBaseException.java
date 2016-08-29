
package br.edu.ifpb.padroes.projeto.conexao;

import java.sql.SQLException;

/**
 *
 * @author Edilva
 */
public class DataBaseException extends SQLException {

    public DataBaseException(String error) {
        super("Erro na base de dados: " + error);
    }
    
}
