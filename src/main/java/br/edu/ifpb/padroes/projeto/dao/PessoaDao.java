package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.conexao.Conexao;
import br.edu.ifpb.padroes.projeto.conexao.ConexaoIF;
import br.edu.ifpb.padroes.projeto.conexao.DataBaseException;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
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
public class PessoaDao implements PessoaDaoIF {

    private ConexaoIF conn;

    public PessoaDao() {

    }

    @Override
    public boolean adicionar(Pessoa pessoa) {
        boolean result = false;

        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "INSERT INTO PESSOA (CPF, NOME, RG, DATA_NASC, EMAIL, TIPO, "
                    + "UF, CIDADE, BAIRRO, RUA, NUMERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getRg());
            ps.setDate(4, Date.valueOf(pessoa.getDataNasc()));
            ps.setString(5, pessoa.getEmail());
            ps.setString(6, String.valueOf(TipoPessoa.PACIENTE));
            ps.setString(7, pessoa.getEndereco().getEstado());
            ps.setString(8, pessoa.getEndereco().getCidade());
            ps.setString(9, pessoa.getEndereco().getBairro());
            ps.setString(10, pessoa.getEndereco().getRua());
            ps.setString(11, pessoa.getEndereco().getNumero());

            if (ps.executeUpdate() > 0) {
                adicionaTelefone(pessoa, ps);
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
    
    private void adicionaTelefone(Pessoa pessoa, PreparedStatement ps) {

        try {
            String sql2 = "INSERT INTO TELEFONE_PESSOA (CPF_PESSOA, TELEFONE) VALUES (?, ?)";
            ps = conn.getConnection().prepareStatement(sql2);
            for (String tel : pessoa.getTelefones()) {
                ps.setString(1, pessoa.getCpf());
                ps.setString(2, tel);
                ps.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean atualizar(Pessoa pessoa, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String cpf) {
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM PESSOA WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);

            if (ps.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public Pessoa buscarPorCpf(String cpf) {
        Pessoa pessoa = new Pessoa();
        PreparedStatement ps = null;
        try {
            conn = new Conexao();
            String sql = "SELECT * FROM PESSOA WHERE CPF = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            pessoa = dadosDaPessoa(rs);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> buscarTodos() {
        PreparedStatement ps = null;
        List<Pessoa> lista = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM PESSOA WHERE TIPO = 'PACIENTE'";
            ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaPessoa(rs));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    private Pessoa dadosDaPessoa(ResultSet rs) throws SQLException {
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

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        List<String> telefones = telefonesDaPessoa(cpf);
        Pessoa pessoa = new Pessoa(cpf, nome, rg, dataNasc, email, endereco, telefones);

        return pessoa;
    }

    private List<String> telefonesDaPessoa(String cpf) {
        PreparedStatement ps = null;
        List<String> telefones = new ArrayList<>();

        try {
            conn = new Conexao();
            String sql = "SELECT * FROM TELEFONE_PESSOA WHERE CPF_PESSOA = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                telefones.add(rs.getString("TELEFONE"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.desconecta(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return telefones;
    }

}
