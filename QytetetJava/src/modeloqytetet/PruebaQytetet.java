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
                + "lo sentimos, ¡Debes ir a la carcel!",0, 
                TipoSorpresa.IRACASILLA));
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
