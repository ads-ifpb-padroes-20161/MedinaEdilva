
package br.edu.ifpb.padroes.projeto.fabrica;

import br.edu.ifpb.padroes.projeto.dao.ClinicaDaoIF;
import br.edu.ifpb.padroes.projeto.dao.FuncionarioDaoIF;
import br.edu.ifpb.padroes.projeto.dao.MedicoDaoIF;
import br.edu.ifpb.padroes.projeto.dao.PessoaDaoIF;
import java.sql.SQLException;

/**
 *
 * @author Edilva
 */
public interface DaoFactoryIF {
    
    public PessoaDaoIF criaPessoa();
    
    public FuncionarioDaoIF criaFuncionario();
    
    public MedicoDaoIF criaMedico();
    
    public ClinicaDaoIF criaClinica();
}
