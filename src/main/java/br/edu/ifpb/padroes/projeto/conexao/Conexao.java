
package br.edu.ifpb.padroes.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edilva
 */
public class Conexao implements ConexaoIF{

    private final String url = "jdbc:postgresql://localhost:5432/SistemaMedico";
    private final String user = "postgres";
    private final String password = "postgres";
    private final String driver = "org.postgresql.Driver";
    public Connection conn;

    public Conexao() throws ClassNotFoundException{
        try {
            System.setProperty("jdbc.Drivers", driver);
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }
    
    @Override
    public Connection getConnection() {
        return conn;
    }
    
    @Override
    public void desconecta(PreparedStatement ps) throws DataBaseException{
        try {
            ps.close();
            this.conn.close();
        } catch (SQLException ex) {
            throw new DataBaseException("Falha ao fechar conex�es: " + ex.getMessage());
        }
    }
    
    @Override
    public void desconecta(Statement st) throws DataBaseException{
        try {
            st.close();
            this.conn.close();
        } catch (SQLException ex) {
            throw new DataBaseException("Falha ao fechar conex�es: " + ex.getMessage());
        }
    }
    
}
