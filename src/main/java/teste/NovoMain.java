/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.edu.ifpb.padroes.projeto.dao.ConsultaDao;
import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Consulta;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.entidades.StatusConsulta;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarBo;
import br.edu.ifpb.padroes.projeto.modelo.ExibirBo;
import br.edu.ifpb.padroes.projeto.modelo.ListarBo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class NovoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Endereco e = new Endereco("PB", "Sousa", "Centro", "Rua João Gualberto", "200");
//        List<String> l = new ArrayList<>();
//        l.add("(83) 9118-8115");
//        l.add("(83) 8178-1113");
//        Medico c = new Medico("PB-3326", "Cardiologia", "100001", "12345", "11.111.111/111-11", "222.444.221-99", "Alberto Nóbrega Campos", "2222222", LocalDate.of(1982, Month.MARCH, 2), "alberto@gmail.com", e, l);
//        CadastrarBo cad = new CadastrarBo();
//        cad.cadastrarMedico(c);
//        ExibirBo ex = new ExibirBo();
//        Pessoa p = ex.exibirPaciente("232.222.111-90");
//        Medico m = ex.exibirMedico("233.444.332-32");
//        Funcionario a = ex.exibirAtendente("111.111.111-11");
//        Consulta c = new Consulta(LocalDate.of(2016, Month.MARCH, 30), LocalTime.of(8, 30), 0, StatusConsulta.AGENDADA, p, m, a);
//        CadastrarBo cad = new CadastrarBo();
//        System.out.println(cad.cadastrarConsulta(c));

//        ListarBo l = new ListarBo();
//        System.out.println(l.listarConsulta());
        ConsultaDao dao = new ConsultaDao();
        System.out.println(dao.buscarPorId(4));
    }

}
