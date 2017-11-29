/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazTextualQytetet;

/**
 *
 * @author jo_se
 */
import modeloqytetet.*;
import java.util.ArrayList;


public class ControladorQytetet {

    static Qytetet juego;
    static Jugador jugador;
    static Casilla casilla;
    static VistaTextualQytetet vista;

    // añadir el siguiente método a ControladorQytetet
    public Casilla elegirPropiedad(ArrayList<Casilla> propiedades) {
        //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
        //luego llama a la vista para que el usuario pueda elegir.
        vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades = new ArrayList();
        for (Casilla casilla : propiedades) {
            listaPropiedades.add("\t" + casilla.getNumeroCasilla() + "\t" + casilla.getTitulo().getNombre());
        }
        seleccion = vista.menuElegirPropiedad(listaPropiedades);
        return propiedades.get(seleccion);
    }


/*public static void main(String[] args) {
        
    }*/
}
