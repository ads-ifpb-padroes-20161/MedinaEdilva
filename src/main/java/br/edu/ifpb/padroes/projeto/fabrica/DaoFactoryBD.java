
package br.edu.ifpb.padroes.projeto.fabrica;

import br.edu.ifpb.padroes.projeto.dao.ClinicaDao;
import br.edu.ifpb.padroes.projeto.dao.ClinicaDaoIF;
import br.edu.ifpb.padroes.projeto.dao.FuncionarioDao;
import br.edu.ifpb.padroes.projeto.dao.FuncionarioDaoIF;
import br.edu.ifpb.padroes.projeto.dao.MedicoDao;
import br.edu.ifpb.padroes.projeto.dao.MedicoDaoIF;
import br.edu.ifpb.padroes.projeto.dao.PessoaDao;
import br.edu.ifpb.padroes.projeto.dao.PessoaDaoIF;

/**
 *
 * @author Edilva
 */
public class DaoFactoryBD implements DaoFactoryIF{

    @Override
    public PessoaDaoIF criaPessoa() {
        return new PessoaDao();
    }

    @Override
    public FuncionarioDaoIF criaFuncionario() {
        return new FuncionarioDao();
    }

    @Override
    public MedicoDaoIF criaMedico() {
        return new MedicoDao();
    }

    @Override
    public ClinicaDaoIF criaClinica() {
        return new ClinicaDao();
    }
    
}
