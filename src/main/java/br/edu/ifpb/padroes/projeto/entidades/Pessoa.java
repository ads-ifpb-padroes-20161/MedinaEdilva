
package br.edu.ifpb.padroes.projeto.entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class Pessoa implements Comparable<Pessoa>{
    private String cpf;
    private String nome;
    private String rg;
    private LocalDate dataNasc;
    private String email;
    private Endereco endereco;
    private TipoPessoa tipo;
    private List<String> telefones;

    public Pessoa(String cpf, String nome, String rg, LocalDate dataNasc, String email, Endereco endereco, List<String> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.email = email;
        this.endereco = endereco;
        this.telefones = telefones;
    }
    
    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }
    
    public List<String> getTelefones(){
        return telefones;
    }
    
    public void setTelefones(List<String> telefones){
        this.telefones = telefones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.rg);
        hash = 89 * hash + Objects.hashCode(this.email);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.getCpf().compareTo(o.getCpf());
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", dataNasc=" + dataNasc + ", email=" + email + ", endereco=" + endereco + ", tipo=" + tipo + ", telefones=" + telefones + '}';
    }

}
