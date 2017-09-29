/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class PruebaQytetet {

    /**
     * @param args the command line arguments
     */

    private static ArrayList<Sorpresa> mazo = new ArrayList();
    
    private static void inicializarSorpresa(){
        mazo.add(new Sorpresa("Te hemos pillado con chanclasy calcetines, "
                + "lo sentimos, ¡Debes ir a la carcel!",9, 
                TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Un fan anonimo a pagado tu fianza. "
                + "Sales de la carcel.", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Has suspendido PDOO en la convocatoria "
                + "extraordinaria.¡Paga doble matricula!", -130, 
                TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Has conseguido una matricula de honor. "
                + "¡ENHORABUENA EMPOLLON!. Te devuelven dinero", 60, 
                TipoSorpresa.PAGARCOBRAR));
    }
    
    private static ArrayList<Sorpresa> getSorpresasValorPositivo(){
        ArrayList<Sorpresa> sorpresas_positiva = new ArrayList();
        for(Sorpresa s : mazo){
            if(s.getValor() > 0)
                sorpresas_positiva.add(s);
        }
        return sorpresas_positiva;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        PruebaQytetet.inicializarSorpresa();
        
        for(Sorpresa s : mazo){
            System.out.println(s.toString());
        }
    }
}
