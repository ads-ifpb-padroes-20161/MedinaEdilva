/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.edu.ifpb.padroes.projeto.entidades.Clinica;
import br.edu.ifpb.padroes.projeto.entidades.Endereco;
import br.edu.ifpb.padroes.projeto.entidades.Funcionario;
import br.edu.ifpb.padroes.projeto.entidades.Medico;
import br.edu.ifpb.padroes.projeto.entidades.Pessoa;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarClinicaBo;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarAtendenteBo;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarMedicoBo;
import br.edu.ifpb.padroes.projeto.modelo.CadastrarPacienteBo;
import br.edu.ifpb.padroes.projeto.modelo.ListarAtendentesBo;
import br.edu.ifpb.padroes.projeto.modelo.ListarPacientesBo;
import java.time.LocalDate;
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
        Endereco end = new Endereco("PB", "Cajazeiras", "Centro", "Rua Fulano", "10");
        List<String> tel = new ArrayList<>();
        tel.add("99988-3101");
        tel.add("99987-3302");
        Clinica c = new Clinica("58.745.091/001-74", "Medina Cajazeiras", "medina.cajazeiras@gmail.com", end, tel);
        CadastrarClinicaBo cad = new CadastrarClinicaBo();
        cad.cadastrar(c);
//        
//          System.out.println(c.toString());
//          System.out.println(tel.toString());
        
//        Medico m = new Medico("3421 - PB", "Dermatologista", "1002", "1234", "222.009.222-11", "Laura Cartaxo", "10031", LocalDate.of(1999, Month.MARCH, 1), "laura@gmail.com", end, tel, "33333333");
//        CadastrarMedicoBo cad = new CadastrarMedicoBo();
//        cad.cadastrar(m);
//        Funcionario f = new Funcionario("1005", "1234", "33333333", "100.009.100-11", "Edilva Carvalho", "22031", LocalDate.of(1995, Month.SEPTEMBER, 11), "edilva@gmail.com", end, tel);
//        CadastrarAtendenteBo cad1 = new CadastrarAtendenteBo();
//        cad1.cadastrar(f);
//        ListarAtendentesBo list = new ListarAtendentesBo();
//        List<Funcionario> pacientes = list.listar();
//        System.out.println(pacientes.toString());
    }
    
}
