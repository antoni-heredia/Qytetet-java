/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jo_se
 */
public class Qytetet {

    private static final Qytetet instance = new Qytetet();
    public static final int MAX_JUGADORES = 4;

    static final int MAX_CARTAS = 10;
    static final int MAX_CASILLA = 20;
    static final int PREICIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;

    private Sorpresa cartaActual;
    private ArrayList<Sorpresa> mazo;
    private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private Dado dado = Dado.getInstance();

    private Qytetet() {
    }

    public static Qytetet getInstance() {
        return instance;
    }

    public boolean aplicarSorpresa() {
        throw new UnsupportedOperationException("sin implementar");
    }

    public boolean cancelarHipoteca(Casilla casilla) {
        throw new UnsupportedOperationException("sin implementar");
    }

    public boolean comprarTituloPropiedad() {
        throw new UnsupportedOperationException("sin implementar");
    }

    public boolean edificarCasa(Casilla casilla) {
        throw new UnsupportedOperationException("sin implementar");
    }

    public boolean edificarHotel(Casilla casilla) {
        throw new UnsupportedOperationException("sin implementar");
    }

    public Sorpresa getCartaActual() {
        return cartaActual;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean hipotecarPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("sin implementar");
    }

    public void inicializarJuego(ArrayList<String> nombres) {
        //throw new UnsupportedOperationException("sin implementar");
        inicializarTablero();
        inicializarJugadores(nombres);
        inicializarCartasSorpresa();
    }

    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        throw new UnsupportedOperationException("sin implementar");
    }

    public boolean jugar() {
        throw new UnsupportedOperationException("sin implementar");
    }

    public List obtenerRanking() {
        throw new UnsupportedOperationException("sin implementar");
    }

    public ArrayList propiedadesHipotecadasJugador(boolean hipotecadas) {
        ArrayList<Casilla> casillas = null;
        ArrayList<TituloPropiedad> titulos = jugadorActual.getPropiedades();
        for(int i = 0; i < titulos.size(); i++){
            
            if(hipotecadas == titulos.get(i).getHipotecada())
                casillas.add(titulos.get(i).getCasilla());
        }
        
        return casillas;

    }
 /**
     * Cambia el jugador actual al siguiente jugador
     *
     * 
     */
    public void siguienteJugador() {
        int posicion_jugador_actual = jugadores.indexOf(jugadorActual);
        jugadorActual = jugadores.get(posicion_jugador_actual % MAX_JUGADORES);
        
       
    }

    public boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    private void encarcelarJugador() {
        throw new UnsupportedOperationException("sin implementar");
    }
    /**
     * 
     */
    private void salidaJugadores() {
        Casilla salida = tablero.obtenerCasillaNumero(0);
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).actualizarPosicion(salida);
        }
        jugadorActual = jugadores.get((int) (Math.random() * jugadores.size()) + 1);
    }

    private void inicializarCartasSorpresa() {
        mazo = new ArrayList(MAX_CARTAS);
        //Cartas de ir a casilla
        mazo.add(new Sorpresa("Te hemos pillado copiando en un examen, "
                + "¡Debes ir a la carcel!", tablero.getCarcel().getNumeroCasilla(),
                TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Son las 15:15 y las 15:30 tienes practicas de EC"
                + ". Deberias ir a por un cafe antes.", 12,
                TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Tu profesor no ha venido y no a avisado antes."
                + " Te toca ir a las mesas rojas", 12,
                TipoSorpresa.IRACASILLA));
        //Carta salir de la carcel
        mazo.add(new Sorpresa("El director de la ETSIIT se ha apiadado de ti. "
                + "Sales de la carcel.", 0, TipoSorpresa.SALIRCARCEL));
        //Carta de pagar o cobrar
        mazo.add(new Sorpresa("Has suspendido PDOO en la convocatoria "
                + "extraordinaria.¡Paga doble matricula!", -130,
                TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Has conseguido una matricula de honor. "
                + "¡ENHORABUENA EMPOLLON!. Te devuelven el dinero", 66,
                TipoSorpresa.PAGARCOBRAR));
        //Cartas por casa u hotel
        mazo.add(new Sorpresa("Empieza un nuevo mes. Tienes que hacerle la "
                + "transferencia al casero.", -180, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("El fin de curso a llegado. El casero te devuelve"
                + " la fianza.", 180, TipoSorpresa.PORCASAHOTEL));
        //Carta por jugador
        mazo.add(new Sorpresa("Tus compañeros te ofrecen dinero para que le "
                + "pases las practicas. Todos hacen un bote y te lo dan", 25, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Tus compañeros te han pillado copiandote. "
                + "Todos te piden dinero por su silencio. Te toca pagar.",
                -15, TipoSorpresa.PORJUGADOR));
    }

    private void inicializarTablero() {
        tablero = new Tablero();
    }

    private void inicializarJugadores(ArrayList<String> nombres) {

        jugadores = new ArrayList(nombres.size());

        for (String nombre : nombres) {
            jugadores.add(new Jugador(nombre));
        }
    }

    @Override
    public String toString() {
        String cadena = "Turno actual: ";

        if (jugadorActual != null) {
            cadena += jugadorActual.toString();
        } else {
            cadena += "El turno actual esta sin definir aun.\n";
        }

        cadena += "Jugadores: ";
        if (jugadores != null && !jugadores.isEmpty()) {
            for (Jugador j : jugadores) {
                cadena += j.toString() + "\n";
            }
        } else {
            cadena += "No hay jugadores \n";
        }

        cadena += "Tablero: ";
        if (tablero != null) {
            cadena += tablero.toString();
        } else {
            cadena += "Tablero no esta iniciado. \n";
        }

        cadena += "Mazo: ";
        if (mazo != null && !mazo.isEmpty()) {
            for (Sorpresa s : mazo) {
                cadena += s.toString() + "\n";
            }
        } else {
            cadena += "No hay jugadores \n";
        }

        return cadena;
    }

}
