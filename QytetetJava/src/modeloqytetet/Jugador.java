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
public class Jugador {

    private boolean encarcelado;
    private String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> propiedades;
    private Casilla casillaActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.encarcelado = false;
        this.saldo = 7500;
        propiedades = new ArrayList();
        //casillaActual = Qytetet.getInstance().getTablero().obtenerCasillaNumero(0);
    }

    //Consultores basicos
    public boolean getEncarcelado() {
        return encarcelado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public Sorpresa getCartaLibertad() {
        return cartaLibertad;
    }

    /**
     * Devuelve una lista con todas las propiedades que tiene el jugador
     *
     * @return arraylist de las propiedades
     */
    public ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }

    /**
     * Retorna el valor de la casilla en la que se encuentra el jugador
     *
     * @return casilla actual del jugador
     */
    public Casilla getCasillaActual() {
        return casillaActual;
    }

    /**
     * Pone valor a cartaLiberta
     *
     * @param carta Debe ser una carta de tipo SalirCarcel
     */
    void setCartaLibertad(Sorpresa carta) throws Exception {

        //Si la carta no es del tipo salir carcel lanzamos una excepcion
        if (carta.getTipo() != TipoSorpresa.SALIRCARCEL) {
            throw new Exception("La carta no es"
                    + " de salir carcel");
        }

        this.cartaLibertad = carta;
    }

    /**
     * Mueve el jugador a otra casilla
     *
     * @param casilla Valor de la casilla a la que se movera
     */
    void setCasillaActual(Casilla casilla) {
        this.casillaActual = casilla;
    }

    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    /**
     * Devuelve si el jugador tiene alguna propiedad
     *
     * @return
     */
    public boolean tengoPropiedades() {
        return !propiedades.isEmpty();
    }

    /**
     * Actualiza la posicion de la casilla del jugador
     *
     * @param casilla
     * @return
     */
    boolean actualizarPosicion(Casilla casilla) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     * Compra un titulo de la propiedad
     *
     * @return
     */
    boolean comprarTitulo() throws UnsupportedOperationException {
        //TODO : Implementar el metodo
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *Elimina la carta libertad si no era nula y la devuelve
     * 
     * @return devuelve la cartaLibertad o null en caso de que el jugador no la tenga.
     */
    Sorpresa devolverCartaLibertad(){
        Sorpresa libertad = null;
        if(cartaLibertad != null){
            libertad = cartaLibertad;
            cartaLibertad = null;
        }
        
        return libertad;
    }

    /**
     *
     * @param casilla
     */
    void irACarcel(Casilla casilla) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *añade un nuevo saldo restando si es negativo o sumado si es positivo
     * @param Cantidad el sado se sumara o restara este valor
     */
    void modificarSaldo(int Cantidad){
        saldo += Cantidad;
    }

    /**
     *
     * @return
     */
    int obtenerCapital(){
        int capital = saldo;
        for (TituloPropiedad t : propiedades) {
            capital += t.getCasilla().getCoste();
            int cant = t.getCasilla().getNumHoteles() + t.getCasilla().getNumCasas();
            capital += cant * t.getPrecioEdificar();
            if (t.getHipotecada()) {
                capital -= t.getHipotecaBase();
            }
        }
        return capital;
    }

    /**
     *
     * @param hipotecadas
     * @return
     */
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecadas) {

        ArrayList<TituloPropiedad> titulos_hipotecados = new ArrayList();
        for (TituloPropiedad t : propiedades) {
            if(t.getHipotecada())
                titulos_hipotecados.add(t);
        }
        return titulos_hipotecados;
    }

    /**
     *
     * @param cantidad
     */
    void pagarCobrarPorCasaYHotel(int cantidad) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @param cantidad
     * @return
     */
    boolean pagarLibertad(int cantidad) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @param casilla
     * @return
     */
    boolean puedoEdificarCasa(Casilla casilla) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @param casilla
     * @return
     */
    boolean puedoEdificarHotel(Casilla casilla) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @param casilla
     * @return
     */
    boolean puedoHipotecar(Casilla casilla) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @param casilla
     * @return
     */
    boolean puedoPagarHipoteca(Casilla casilla) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     * Comprueba si la casilla es de mi propiedad y si no esta hipoteca
     * @param casilla
     * @return true si es de mi propiedad y no esta hipotecada fase en otro caso
     */
    boolean puedoVenderPropiedad(Casilla casilla){
       boolean vender = false;
       if(this.esDeMiPropiedad(casilla) && !casilla.getTitulo().getHipotecada())
           vender = true;
       
       return vender;
    }

    /**
     * Comrpueba si se tiene carta libertad
     * 
     * @return bool true si se tiene carta false si no se tiene.
     */
    boolean tengoCartaLiberdad(){
        boolean libertad = false;
        if(cartaLibertad != null)
            libertad = true;
        
        return libertad;
    }

    /**
     *
     * @param casilla
     */
    void venderPropiedad(Casilla casilla) throws UnsupportedOperationException {
        //TODO 
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @return
     */
    private int cuantasCasasHotelTengo(){
        int cantidad = 0;
        for (TituloPropiedad t : propiedades) {
            cantidad += t.getCasilla().getNumCasas() + t.getCasilla().getNumHoteles();
        }
        return cantidad;
    }

    /**
     *
     * @param casilla
     */
    private void eliminarDeMisPropiedades(Casilla casilla){
        for (TituloPropiedad t : propiedades) {
            if (t.getCasilla().getNumeroCasilla() == casilla.getNumeroCasilla()) {
                propiedades.remove(t);
            }
        }
    }

    /**
     *
     * @param casilla
     * @return
     */
    private boolean esDeMiPropiedad(Casilla casilla){
        boolean f = false;
        for (TituloPropiedad t : propiedades) {
            if (t.getCasilla().getNumeroCasilla() == casilla.getNumeroCasilla()) {
                f = true;
            }
        }
        return f;
    }

    /**
     *
     * @param cantidad
     * @return
     */
    private boolean tengoSaldo(int cantidad){
        return (saldo >= cantidad);
    }

    /**
     * Devuelve la informacion del jugador en forma de string
     *
     * @return
     */
    @Override
    public String toString() {

        String texto = "Nombre: " + nombre + "\nSaldo: " + saldo;
        if (cartaLibertad != null) {
            texto += "\nCarta de libertad: " + cartaLibertad.toString();
        }
        if (casillaActual != null) {
            texto += "\nCasilla actual: " + casillaActual.toString();
        }
        if (propiedades != null) {
            texto += "\nNumero de propiedades: " + propiedades.size();
            if (!propiedades.isEmpty()) {
                texto += "\nPropiedades:{";

                for (TituloPropiedad t : propiedades) {
                    texto += " " + t.toString();
                }
            }
        }
        texto += "\n";
        return texto;
    }
}
