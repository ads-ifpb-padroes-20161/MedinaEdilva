
package br.edu.ifpb.padroes.projeto.dao;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ClinicaDaoIF {
    
    public boolean adicionar(Clinica clinica);

    public boolean atualizar(Clinica clinica, String cnpj);

    public boolean remover(String cnpj);
    
    public Clinica exibir(String cnpj);
    
    public List<Clinica> listarClinica();
}
