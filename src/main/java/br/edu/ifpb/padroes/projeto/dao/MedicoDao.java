package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.conexao.Conexao;
import br.edu.ifpb.padroes.projeto.conexao.ConexaoIF;
import br.edu.ifpb.padroes.projeto.conexao.DataBaseException;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.TipoPessoa;
import java.io.IOException;
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
public class MedicoDao implements MedicoDaoIF {

    private ConexaoIF conn;

    public MedicoDao() {

    }

    @Override
    public boolean adicionar(Medico medico) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "INSERT INTO MEDICO (CPF, NOME, RG, DATA_NASC, EMAIL, "
                    + "UF, CIDADE, BAIRRO, RUA, NUMERO, MATRICULA, SENHA, CNPJ_CLINICA, CRM, ESPECIALIDADE) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getRg());
            ps.setDate(4, Date.valueOf(medico.getDataNasc()));
            ps.setString(5, medico.getEmail());
            ps.setString(6, medico.getEndereco().getEstado());
            ps.setString(7, medico.getEndereco().getCidade());
            ps.setString(8, medico.getEndereco().getBairro());
            ps.setString(9, medico.getEndereco().getRua());
            ps.setString(10, medico.getEndereco().getNumero());
            ps.setString(11, medico.getMatricula());
            ps.setString(12, medico.getSenha());
            ps.setString(13, medico.getCnpjClinica());
            ps.setString(14, medico.getCrm());
            ps.setString(15, medico.getEspecialidade());

            if (ps.executeUpdate() > 0) {
                adicionaTelefone(medico, ps);
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    private void adicionaTelefone(Medico medico, PreparedStatement ps) {

        try {
            String sql2 = "INSERT INTO TELEFONE_MEDICO (CPF_MEDICO, TELEFONE) VALUES (?, ?)";
            ps = conn.getConnection().prepareStatement(sql2);
            for (String tel : medico.getTelefones()) {
                ps.setString(1, medico.getCpf());
                ps.setString(2, tel);
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean atualizar(Medico medico, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String cpf) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM MEDICO WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);

            if (ps.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public Medico buscarPorCpf(String cpf) {
        PreparedStatement ps = null;
        Medico medico = new Medico();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM MEDICO WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medico = dadosDoMedico(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return medico;
    }

    @Override
    public List<Medico> buscarTodos() {
        PreparedStatement ps = null;
        List<Medico> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM  MEDICO";
            ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDoMedico(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    @Override
    public Medico login(String matricula, String senha) {
        PreparedStatement ps = null;
        Medico medico = null;

        try {
            conn = new Conexao();

            String sql = "SELECT * FROM MEDICO WHERE MATRICULA = ? AND SENHA = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, matricula);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medico = dadosDoMedico(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return medico;
    }

    private Medico dadosDoMedico(ResultSet rs) throws SQLException {
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
        String crm = rs.getString("CRM");
        String especialidade = rs.getString("ESPECIALIDADE");

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        List<String> telefones = telefonesDoFuncionario(cpf);
        Medico medico = new Medico(crm, especialidade, matricula, senha, cnpjClinica, cpf, nome, rg, dataNasc, email, endereco, telefones);

        return medico;
    }

    private List<String> telefonesDoFuncionario(String cpf) {
        PreparedStatement ps = null;
        List<String> telefones = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM TELEFONE_MEDICO WHERE CPF_MEDICO = ?";
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
