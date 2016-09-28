package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.conexao.Conexao;
import br.edu.ifpb.padroes.projeto.conexao.ConexaoIF;
import br.edu.ifpb.padroes.projeto.conexao.DataBaseException;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class FuncionarioDao implements FuncionarioDaoIF {

    private ConexaoIF conn;

    public FuncionarioDao() {

    }

    @Override
    public boolean adicionar(Funcionario funcionario) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "INSERT INTO FUNCIONARIO (CPF, NOME, RG, DATA_NASC, EMAIL, "
                    + "UF, CIDADE, BAIRRO, RUA, NUMERO, MATRICULA, SENHA, CNPJ_CLINICA) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getRg());
            ps.setDate(4, Date.valueOf(funcionario.getDataNasc()));
            ps.setString(5, funcionario.getEmail());
            ps.setString(6, funcionario.getEndereco().getEstado());
            ps.setString(7, funcionario.getEndereco().getCidade());
            ps.setString(8, funcionario.getEndereco().getBairro());
            ps.setString(9, funcionario.getEndereco().getRua());
            ps.setString(10, funcionario.getEndereco().getNumero());
            ps.setString(11, funcionario.getMatricula());
            ps.setString(12, funcionario.getSenha());
            ps.setString(13, funcionario.getCnpjClinica());

            if (ps.executeUpdate() > 0) {
                adicionaTelefone(funcionario, ps);
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    private void adicionaTelefone(Funcionario funcionario, PreparedStatement ps) {

        try {
            String sql2 = "INSERT INTO TELEFONE_FUNCIONARIO (CPF_FUNCIONARIO, TELEFONE) VALUES (?, ?)";
            ps = conn.getConnection().prepareStatement(sql2);
            for (String tel : funcionario.getTelefones()) {
                ps.setString(1, funcionario.getCpf());
                ps.setString(2, tel);
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean atualizar(Funcionario funcionario, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String cpf) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM FUNCIONARIO WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);

            if (ps.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public Funcionario buscarPorCpf(String cpf) {
        Funcionario funcionario = new Funcionario();
        PreparedStatement ps = null;
        try {
            conn = new Conexao();
            String sql = "SELECT * FROM FUNCIONARIO WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = dadosDoFuncionario(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        PreparedStatement ps = null;
        List<Funcionario> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM FUNCIONARIO";
            ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDoFuncionario(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    @Override
    public Funcionario login(String matricula, String senha) {
        PreparedStatement ps = null;
        Funcionario funcionario = null;

        try {
            conn = new Conexao();

            String sql = "SELECT * FROM FUNCIONARIO WHERE MATRICULA = ? AND SENHA = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, matricula);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = dadosDoFuncionario(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return funcionario;
    }

    private Funcionario dadosDoFuncionario(ResultSet rs) throws SQLException {
        String cpf = rs.getString("CPF");
        String nome = rs.getString("NOME");
        String rg = rs.getString("RG");
        LocalDate dataNasc = rs.getDate("DATA_NASC").toLocalDate();
        String email = rs.getString("EMAIL");
        String estado = rs.getString("UF");
        String cidade = rs.getString("CIDADE");
        String bairro = rs.getString("BAIRRO");
        String rua = rs.getString("RUA");
        String numero = rs.getString("NUMERO");
        String matricula = rs.getString("MATRICULA");
        String senha = rs.getString("SENHA");
        String cnpjClinica = rs.getString("CNPJ_CLINICA");

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        List<String> telefones = telefonesDoFuncionario(cpf);
        Funcionario funcionario = new Funcionario(matricula, senha, cnpjClinica, cpf, nome, rg, dataNasc, email, endereco, telefones);

        return funcionario;
    }

    private List<String> telefonesDoFuncionario(String cpf) {
        PreparedStatement ps = null;
        List<String> telefones = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM TELEFONE_FUNCIONARIO WHERE CPF_FUNCIONARIO = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                telefones.add(rs.getString("TELEFONE"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return telefones;
    }

}
