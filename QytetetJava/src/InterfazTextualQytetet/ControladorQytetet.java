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
        return jugador.getSaldo() <= 0;
    }

    private static void desarolloJuego() {
        while (!bancarrota()) {
            vista.mostrar("Turno de: \n" + jugador.toString());

            boolean libre = true;
            if (jugador.getEncarcelado()) {
                vista.mostrar("Esta usted en la carcel: \n");
                libre = false;
                switch (vista.menuSalirCarcel()) {
                    case 0:
                        libre = juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                        break;
                    case 1:
                        libre = juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                        break;
                }

                if (!libre) {
                    vista.mostrar("No has podido salir de la carcel");
                    vista.pausa();

                } else {
                    vista.mostrar("El jugador ha salido de la carcel(Su nuevo saldo es "
                            + jugador.getSaldo() + ")");
                }
            }

            if (libre) {
                vista.pausa();
                boolean notienepropietario = juego.jugar();
                casilla = jugador.getCasillaActual();

                vista.mostrar("\n Estado actual del jugador: " + jugador.toString());
                /*
            Hya que volver a comprar 
                 */
                if (!bancarrota()) {

                    if (!jugador.getEncarcelado()) {

                        if (casilla.getTipo() == TipoCasilla.CALLE) {
                            vista.mostrar(casilla.toString());
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
                        } else if (casilla.getTipo() == TipoCasilla.SORPRESA) {
                            vista.mostrar("Ha caido en la carta sorpresa\n");
                            vista.mostrar("La carte que le ha tocado es: " + juego.getCartaActual().toString() + "\n");

                            notienepropietario = juego.aplicarSorpresa();
                            casilla = jugador.getCasillaActual();
                            if (!jugador.getEncarcelado()) {
                                if (!bancarrota()) {
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
                            }
                        }

                        if (!jugador.getEncarcelado() && !bancarrota() && jugador.tengoPropiedades()) {
                            int opcion = 1;
                            while (opcion != 0 && jugador.tengoPropiedades()) {
                                opcion = vista.menuGestionInmobiliaria();
                                ArrayList<Casilla> casillas;
                                Casilla casillaElegida;
                                switch (opcion) {

                                    case 0:
                                        break;
                                    case 1:
                                        vista.mostrar("Todas tus propiedades: \n");
                                        casillas = juego.propiedadesHipotecadasJugador(true);
                                        casillas.addAll(juego.propiedadesHipotecadasJugador(false));
                                        casillaElegida = elegirPropiedad(casillas);
                                        juego.edificarCasa(casillaElegida);
                                        break;
                                    case 2:
                                        vista.mostrar("Todas tus propiedades: \n");
                                        casillas = juego.propiedadesHipotecadasJugador(true);
                                        casillas.addAll(juego.propiedadesHipotecadasJugador(false));
                                        casillaElegida = elegirPropiedad(casillas);
                                        juego.edificarHotel(casillaElegida);

                                        break;
                                    case 3:
                                        casillas = juego.propiedadesHipotecadasJugador(false);
                                        if (!casillas.isEmpty()) {
                                            vista.mostrar("Tus propiedades no hipotecadas: \n");
                                            casillaElegida = elegirPropiedad(casillas);
                                            juego.venderPropiedad(casillaElegida);
                                        } else {
                                            vista.mostrar("No tiene propiedades para realizar esta opcion\n");
                                        }
                                        break;
                                    case 4:
                                        casillas = juego.propiedadesHipotecadasJugador(false);
                                        if (!casillas.isEmpty()) {
                                            vista.mostrar("Tus propiedades no Hipotecadas: \n");
                                            casillaElegida = elegirPropiedad(casillas);
                                            juego.hipotecarPropiedad(casillaElegida);
                                        } else {
                                            vista.mostrar("No tiene propiedades para realizar esta opcion\n");
                                        }

                                        break;
                                    case 5:
                                        casillas = juego.propiedadesHipotecadasJugador(true);
                                        if (!casillas.isEmpty()) {
                                            vista.mostrar("Tus propiedades hipotecadas: \n");
                                            casillaElegida = elegirPropiedad(casillas);
                                            juego.cancelarHipoteca(casillaElegida);
                                        } else {
                                            vista.mostrar("No tiene propiedades para realizar esta opcion\n");
                                        }
                                        break;
                                }
                            }
                        }
                        if (!jugador.tengoPropiedades() && !jugador.getEncarcelado() && !bancarrota()) {
                            vista.mostrar("Usted no tiene propiedades para gestionar\n");
                        }

                    }
                }
            }

            if (!bancarrota()) {
                jugador = juego.siguienteJugador();
                casilla = jugador.getCasillaActual();

            }
        }
        System.out.println(juego.obtenerRanking());

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
        //vista.pausa();
    }

    public static void main(String[] args) {

        inicializarJuego();
        desarolloJuego();
    }

}
