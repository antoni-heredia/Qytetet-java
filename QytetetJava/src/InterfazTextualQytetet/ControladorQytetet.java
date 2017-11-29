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
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class ControladorQytetet {

    static Qytetet juego;
    static Jugador jugador;
    static Casilla casilla;
    static VistaTextualQytetet vista = new VistaTextualQytetet();
    
    
    
    //funciones privadas para el funcionamiento del juego
    

    // añadir el siguiente método a ControladorQytetet
    public static Casilla elegirPropiedad(ArrayList<Casilla> propiedades) {
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

    public static void inicializarJuego() {
       juego = Qytetet.getInstance();
       //ArrayList<String> nombres = vista.obtenerNombreJugadores();
       ArrayList<String> nombres = new ArrayList();
       nombres.add("pepe");
       nombres.add("juan");
       juego.inicializarJuego(nombres);
       jugador = juego.getJugadorActual();
       casilla = jugador.getCasillaActual();
       //vista.mostrar(texto); 
       
       //ArrayList<String> nombres = new ArrayList(vista.obtenerNombreJugadores());
       
    }
    public static void main(String[] args) {
        inicializarJuego();
    }
    


   
}
