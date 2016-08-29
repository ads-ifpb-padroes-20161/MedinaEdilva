
package br.edu.ifpb.padroes.projeto.entidades;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class Medico extends Funcionario{
    private String crm;
    private String especialidade;

    public Medico(String crm, String especialidade, String matricula, String senha, String cnpjClinica, String cpf, String nome, String rg, LocalDate dataNasc, String email, Endereco endereco, List<String> telefones) {
        super(matricula, senha, cnpjClinica, cpf, nome, rg, dataNasc, email, endereco, telefones);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", especialidade=" + especialidade + '}';
    }
}
