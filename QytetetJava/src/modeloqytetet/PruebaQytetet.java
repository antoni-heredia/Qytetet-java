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
    
    private static ArrayList<Sorpresa> obtenertSorpresasValorPositivo(){
        ArrayList<Sorpresa> sorpresasPositivas = new ArrayList();
        for(Sorpresa s : mazo){
            if(s.getValor() > 0)
                sorpresasPositivas.add(s);
        }
        return sorpresasPositivas;
    }
    
    private static ArrayList<Sorpresa> obtenerSorpresasTipoIrACasilla(){
        ArrayList<Sorpresa> sorpresasIrACasilla = new ArrayList();
        
        for(Sorpresa s : mazo){
            if(s.getTipo() == TipoSorpresa.IRACASILLA)
                sorpresasIrACasilla.add(s);
        }
        
        return sorpresasIrACasilla;
    }
    
    private static ArrayList<Sorpresa> buscarSorpresasPorTipo(TipoSorpresa tipo){
        ArrayList<Sorpresa> sorpresasTipo = new ArrayList();
        
        for(Sorpresa s : mazo){
            if(s.getTipo() == tipo){
                sorpresasTipo.add(s);
            }
        }
        
        return sorpresasTipo;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here

        PruebaQytetet.inicializarSorpresa();
        ArrayList<Sorpresa> sorpresasPositivas = PruebaQytetet.obtenertSorpresasValorPositivo();
        ArrayList<Sorpresa> sorpresasTipoIrACasilla = PruebaQytetet.obtenerSorpresasTipoIrACasilla();
        ArrayList<Sorpresa> sorpresasTipoIrACasillaBuscadas = PruebaQytetet.buscarSorpresasPorTipo(TipoSorpresa.PAGARCOBRAR);

        for(Sorpresa s : mazo){
            System.out.println(s.toString());
        }
        for(Sorpresa s : sorpresasPositivas){
            System.out.println(s.toString());
        }
        for(Sorpresa s : sorpresasTipoIrACasilla){
            System.out.println(s.toString());
        }
        for(Sorpresa s : sorpresasTipoIrACasillaBuscadas){
            System.out.println(s.toString());
        }
        
        
    }
}
