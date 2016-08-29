
package br.edu.ifpb.padroes.projeto.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Edilva
 */
public class Consulta {
    private int codCounsulta;
    private String tipoConsulta;
    private LocalDate data;
    private LocalTime hora;
    private String convenio;
    private double valor;
    private String retorno;
    private StatusConsulta status;
    private Pessoa paciente;
    private Medico medico;
    private Funcionario atendente;

    public Consulta(int codCounsulta, String tipoConsulta, LocalDate data, LocalTime hora, String convenio, double valor, String retorno, StatusConsulta status, Pessoa paciente, Medico medico, Funcionario atendente) {
        this.codCounsulta = codCounsulta;
        this.tipoConsulta = tipoConsulta;
        this.data = data;
        this.hora = hora;
        this.convenio = convenio;
        this.valor = valor;
        this.retorno = retorno;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.atendente = atendente;
    }

    public Consulta() {
    }

    public int getCodCounsulta() {
        return codCounsulta;
    }

    public void setCodCounsulta(int codCounsulta) {
        this.codCounsulta = codCounsulta;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Funcionario getAtendente() {
        return atendente;
    }

    public void setAtendente(Funcionario atendente) {
        this.atendente = atendente;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codCounsulta=" + codCounsulta + ", tipoConsulta=" + tipoConsulta + ", data=" + data + ", hora=" + hora + ", convenio=" + convenio + ", valor=" + valor + ", retorno=" + retorno + ", status=" + status + ", paciente=" + paciente + ", medico=" + medico + ", atendente=" + atendente + '}';
    }
}
