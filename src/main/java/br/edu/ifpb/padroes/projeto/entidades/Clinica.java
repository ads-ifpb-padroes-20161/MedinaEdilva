
package br.edu.ifpb.padroes.projeto.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class Clinica implements Comparable<Clinica>{
    private String cnpj;
    private String nome;
    private String email;
    private Endereco enderecoClinica;
    private List<String> telefones;

    public Clinica(String cnpj, String nome, String email, Endereco enderecoClinica, List<String> telefones) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.enderecoClinica = enderecoClinica;
        this.telefones = telefones;
    }


    public Clinica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEnderecoClinica() {
        return enderecoClinica;
    }

    public void setEnderecoClinica(Endereco enderecoClinica) {
        this.enderecoClinica = enderecoClinica;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cnpj);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.enderecoClinica);
        hash = 59 * hash + Objects.hashCode(this.telefones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clinica other = (Clinica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.enderecoClinica, other.enderecoClinica)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Clinica o) {
        return this.getCnpj().compareTo(o.getCnpj());
    }
    
    @Override
    public String toString() {
        return "Clinica{" + "cnpj=" + cnpj + ", nome=" + nome + ", email=" + email + ", enderecoClinica=" + enderecoClinica + ", telefones=" + telefones + '}';
    }
}
