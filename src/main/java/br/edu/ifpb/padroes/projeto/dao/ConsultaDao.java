package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.conexao.Conexao;
import br.edu.ifpb.padroes.projeto.conexao.ConexaoIF;
import br.edu.ifpb.padroes.projeto.conexao.DataBaseException;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.entidades.StatusConsulta;
import br.edu.ifpb.padroes.projeto.modelo.ExibirBo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ConsultaDao implements ConsultaDaoIF {

    private ConexaoIF conn;

    public ConsultaDao() {
    }

    @Override
    public boolean adicionar(Consulta consulta) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "INSERT INTO CONSULTA (DATA, HORA, VALOR, STATUS) VALUES (?, ?, ?, ?)";
            ps = conn.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(consulta.getData()));
            ps.setTime(2, Time.valueOf(consulta.getHora()));
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getStatus().name());

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    consulta.setId(rs.getInt("ID"));
                }
                String sql2 = "INSERT INTO AGENDA_CONSULTA (ID_CONSULTA, CPF_MEDICO, CPF_FUNCIONARIO, CPF_PACIENTE) "
                        + "VALUES (?, ?, ?, ?)";
                ps = conn.getConnection().prepareStatement(sql2);
                ps.setInt(1, consulta.getId());
                ps.setString(2, consulta.getMedico().getCpf());
                ps.setString(3, consulta.getAtendente().getCpf());
                ps.setString(4, consulta.getPaciente().getCpf());
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public boolean atualizar(Consulta consulta, int codConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM CONSULTA WHERE ID = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public Consulta buscarPorId(int id) {
        Consulta consulta = null;
        PreparedStatement ps = null;
        try {
            conn = new Conexao();
            String sql = "SELECT * FROM (CONSULTA C JOIN AGENDA_CONSULTA A ON C.ID = A.ID_CONSULTA) "
                    + "WHERE C.ID = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                consulta = dadosDaConsulta(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consulta;
    }

    @Override
    public boolean cancelarConsulta(int id) {
        PreparedStatement ps = null;
        boolean resultado = false;
        try {
            conn = new Conexao();
            String sql = "UPDATE CONSULTA SET STATUS = 'CANCELADA' WHERE ID = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public boolean realizarConsulta(int id) {
        PreparedStatement ps = null;
        boolean resultado = false;
        try {
            conn = new Conexao();
            String sql = "UPDATE CONSULTA SET STATUS = 'REALIZADA' WHERE ID = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    private Consulta dadosDaConsulta(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        LocalDate data = rs.getDate("DATA").toLocalDate();
        LocalTime hora = rs.getTime("HORA").toLocalTime();
        double valor = rs.getDouble("VALOR");
        StatusConsulta status = StatusConsulta.valueOf(rs.getString("STATUS"));
        String cpfPaciente = rs.getString("CPF_PACIENTE");
        String cpfAtendente = rs.getString("CPF_FUNCIONARIO");
        String cpfMedico = rs.getString("CPF_MEDICO");

        ExibirBo exibir = new ExibirBo();
        Pessoa paciente = exibir.exibirPaciente(cpfPaciente);
        Funcionario atendente = exibir.exibirAtendente(cpfAtendente);
        Medico medico = exibir.exibirMedico(cpfMedico);

        Consulta consulta = new Consulta(id, data, hora, valor, status, paciente, medico, atendente);
        return consulta;
    }

    @Override
    public List<Consulta> buscarTodos() {
        PreparedStatement ps = null;
        List<Consulta> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM (CONSULTA C JOIN AGENDA_CONSULTA A ON C.ID = A.ID_CONSULTA)";
            ps = conn.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(dadosDaConsulta(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    @Override
    public List<Consulta> buscarPorPaciente(String cpf) {
        PreparedStatement ps = null;
        List<Consulta> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM (CONSULTA C JOIN AGENDA_CONSULTA A ON C.ID = A.ID_CONSULTA) "
                    + "WHERE A.CPF_PACIENTE = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaConsulta(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    @Override
    public List<Consulta> buscarPorMedico(String cpf) {
        PreparedStatement ps = null;
        List<Consulta> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM (CONSULTA C JOIN AGENDA_CONSULTA A ON C.ID = A.ID_CONSULTA) "
                    + "WHERE C.CPF_MEDICO = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaConsulta(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ConsultaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

}
