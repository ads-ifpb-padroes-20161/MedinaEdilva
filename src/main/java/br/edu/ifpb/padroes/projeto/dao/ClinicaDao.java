package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.conexao.Conexao;
import br.edu.ifpb.padroes.projeto.conexao.ConexaoIF;
import br.edu.ifpb.padroes.projeto.conexao.DataBaseException;
import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ClinicaDao implements ClinicaDaoIF {

    private ConexaoIF conn;

    public ClinicaDao() {

    }

    @Override
    public boolean adicionar(Clinica clinica) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "INSERT INTO CLINICA (CNPJ, NOME, EMAIL, "
                    + "UF, CIDADE, BAIRRO, RUA, NUMERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, clinica.getCnpj());
            ps.setString(2, clinica.getNome());
            ps.setString(3, clinica.getEmail());
            ps.setString(4, clinica.getEnderecoClinica().getEstado());
            ps.setString(5, clinica.getEnderecoClinica().getCidade());
            ps.setString(6, clinica.getEnderecoClinica().getBairro());
            ps.setString(7, clinica.getEnderecoClinica().getRua());
            ps.setString(8, clinica.getEnderecoClinica().getNumero());

            if (ps.executeUpdate() > 0) {
                adicionaTelefone(clinica, ps);
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    private void adicionaTelefone(Clinica clinica, PreparedStatement ps) {

        try {
            String sql2 = "INSERT INTO TELEFONE_CLINICA (CNPJ_CLINICA, TELEFONE) VALUES (?, ?)";
            ps = conn.getConnection().prepareStatement(sql2);
            for (String tel : clinica.getTelefones()) {
                ps.setString(1, clinica.getCnpj());
                ps.setString(2, tel);
                ps.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean atualizar(Clinica clinica, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String cnpj) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM CLINICA WHERE CNPJ = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cnpj);

            if (ps.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public List<Clinica> listarClinica() {
        List<Clinica> lista = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            conn = new Conexao();
            String sql = "SELECT * FROM CLINICA";
            ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaClinica(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    private Clinica dadosDaClinica(ResultSet rs) throws SQLException {
        String cnpj = rs.getString("CNPJ");
        String nome = rs.getString("NOME");
        String email = rs.getString("EMAIL");
        String estado = rs.getString("UF");
        String cidade = rs.getString("CIDADE");
        String bairro = rs.getString("BAIRRO");
        String rua = rs.getString("RUA");
        String numero = rs.getString("NUMERO");

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        List<String> telefones = telefonesDaClinica(cnpj);
        Clinica clinica = new Clinica(cnpj, nome, email, endereco, telefones);

        return clinica;
    }

    private List<String> telefonesDaClinica(String cnpj) {
        PreparedStatement ps;
        List<String> telefones = new ArrayList();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM TELEFONE_CLINICA WHERE CNPJ_CLINICA = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                telefones.add(rs.getString("TELEFONE"));
            }
            conn.desconecta(ps);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return telefones;
    }
    
    @Override
    public Clinica exibir(String cnpj){
        Clinica clinica = null;
        PreparedStatement ps = null;
        try {
            conn = new Conexao();
            String sql = "SELECT * FROM CLINICA WHERE CNPJ = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clinica = dadosDaClinica(rs);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clinica;
    }

}
