
package br.edu.ifpb.padroes.projeto.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Edilva
 */
public class Consulta {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    private StatusConsulta status;
    private Pessoa paciente;
    private Medico medico;
    private Funcionario atendente;

    public Consulta(int id, LocalDate data, LocalTime hora, double valor, StatusConsulta status, Pessoa paciente, Medico medico, Funcionario atendente) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.atendente = atendente;
    }

    public Consulta(LocalDate data, LocalTime hora, double valor, StatusConsulta status, Pessoa paciente, Medico medico, Funcionario atendente) {
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.atendente = atendente;
    }

    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        return "Consulta{" + "id=" + id + ", data=" + data + ", hora=" + hora + ", valor=" + valor + ", status=" + status + ", paciente=" + paciente + ", medico=" + medico + ", atendente=" + atendente + '}';
    }
}
