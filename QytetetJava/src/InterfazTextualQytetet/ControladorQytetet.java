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
    private static boolean bancarrota() {
        if (jugador.getSaldo() <= 0) {
            juego.siguienteJugador();
            jugador = juego.getJugadorActual();
        }

        return jugador.getSaldo() <= 0;
    }

    private static void desarolloJuego() {
        if (jugador.getEncarcelado()) {
            boolean libre = false;

            switch (vista.menuSalirCarcel()) {
                case 1:
                    libre = juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                    break;
                case 2:
                    libre = juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                    break;
            }

            if (!libre) {
                vista.mostrar("No has podido salir de la carcel");
                if (bancarrota()) {
                    System.out.println(juego.obtenerRanking());
                }
            } else {
                vista.mostrar("El jugador ha salido de la carcel");
            }
        }

        boolean notienepropietario = juego.jugar();
        casilla = jugador.getCasillaActual();
        /*
            Hya que volver a comprar 
         */
        if (jugador.getSaldo() <= 0) {
            bancarrota();
        }
        if (jugador.getEncarcelado()) {
            bancarrota();
        }

        if (casilla.getTipo() == TipoCasilla.CALLE) {
            if (!notienepropietario) {
                boolean comprar = vista.elegirQuieroComprar();
                if (comprar) {
                    if (juego.comprarTituloPropiedad()) {
                        vista.mostrar("Se ha comprado la propiedad");
                    } else {
                        vista.mostrar("No se ha podido comprar la propiedad");
                    }
                }

            }
        }
    }
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

        //System.out.println(juego.toString());
    }

    public static void main(String[] args) {

        inicializarJuego();
        desarolloJuego();
    }

}
