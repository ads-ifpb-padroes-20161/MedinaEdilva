/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.padroes.projeto.modelo;

import br.edu.ifpb.padroes.projeto.fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class RemoverMedicoBo {
    
    public boolean remover(String cpf) {
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMedico().remover(cpf);
    }
}
