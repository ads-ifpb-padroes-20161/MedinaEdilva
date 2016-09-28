
package br.edu.ifpb.padroes.projeto.entidades;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class Funcionario extends Pessoa{
    private String matricula;
    private String senha;
    private String cnpjClinica;

    public Funcionario(String matricula, String senha, String cnpjClinica, String cpf, String nome, String rg, LocalDate dataNasc, String email, Endereco endereco, List<String> telefones) {
        super(cpf, nome, rg, dataNasc, email, endereco, telefones);
        this.matricula = matricula;
        this.senha = senha;
        this.cnpjClinica = cnpjClinica;
    }

    public Funcionario() {
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpjClinica() {
        return cnpjClinica;
    }

    public void setCnpjClinica(String cnpjClinica) {
        this.cnpjClinica = cnpjClinica;
    }

    @Override
    public String toString() {
        return "Funcionario{" + super.toString() + "matricula=" + matricula + ", senha=" + senha + ", cnpjClinica=" + cnpjClinica + '}';
    }

}
