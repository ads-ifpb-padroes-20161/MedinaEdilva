
package br.edu.ifpb.padroes.projeto.fabrica;

/**
 *
 * @author Edilva
 */
public class DaoFactory {
    
    public static final int DAO_BD = 0;
    
    public static DaoFactoryIF createFactory(int factoryType){
        if(factoryType == DAO_BD){
            return new DaoFactoryBD();
        }
        return null;
    }
}
