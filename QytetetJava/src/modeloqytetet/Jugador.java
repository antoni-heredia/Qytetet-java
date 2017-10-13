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
    void setCartaLibertad(Sorpresa carta) {

        //Si la carta no es del tipo salir carcel lanzamos una excepcion
        if (carta.getTipo() != TipoSorpresa.SALIRCARCEL) {
            throw new UnsupportedOperationException("La carta no es"
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
    boolean actualizarPosicion(Casilla casilla) {
        return false;
    }

    /**
     * Compra un titulo de la propiedad
     *
     * @return
     */
    boolean comprarTitulo() {
        //TODO : Implementar el metodo
        return false;
    }

    /**
     *
     * @return
     */
    Sorpresa devolverCartaLibertad() {
        //TODO : Implementar el metodo
        return null;
    }
    
    /**
     * 
     * @param casilla 
     */
    void  irACarcel(Casilla casilla){
        //TODO
    }
    
    /**
     * 
     * @param Cantidad 
     */
    void modificarSaldo(int Cantidad){
        
    }
    
    /**
     * 
     * @return 
     */
    int obtenerCapital(){
        //TODO
        return 0; 
    }
    
    /**
     * 
     * @param hipotecadas
     * @return 
     */
    ArrayList<TituloPropiedad> obtenerProppiedadesHipotecadas(boolean hipotecadas){
        //TODO
        return null;
    }
    
    /**
     * 
     * @param cantidad 
     */
    void pagarCobrarPorCasaYHotel(int cantidad){
        //TODO
    }
    
    /**
     * 
     * @param cantidad
     * @return 
     */
    boolean pagarLibertad(int cantidad){
        //TODO
        return false;
    }
    
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoEdificarCasa(Casilla casilla){
        //TODO
        return false;
    }

    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoEdificarHotel(Casilla casilla){
        //TODO
        return false;
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoHipotecar(Casilla casilla){
        //TODO
        return false;
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoPagarHipoteca(Casilla casilla){
        //TODO
        return false;
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoVenderPropiedad(Casilla casilla){
        //TODO
        return false; 
    }
    
    /**
     * 
     * @param carta
     * @return 
     */
    boolean tengoCartaLiberdad(Sorpresa carta){
        //TODO
       return false; 
    }
    
    /**
     * 
     * @param casilla 
     */
    void venderPropiedad(Casilla casilla){
       //TODO 
    }
    
    /**
     * 
     * @return 
     */
    private int cuantasCasasHotelTengo(){
        //TODO
        return 0;
    }
    
    
    /**
     * 
     * @param casilla 
     */
    private void eliminarDeMisPropiedades(Casilla casilla){
        //TODO
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    private boolean esDeMiPropiedad(Casilla casilla){
        //TODO
        return false;
    } 
    
    /**
     * 
     * @param cantidad
     * @return 
     */
    private boolean tengoSaldo(int cantidad){
        //TODO
        return false;
    }
    
    /**
     * Devuelve la informacion del jugador en forma de string
     *
     * @return
     */
    @Override
    public String toString() {

        String texto = "Nombre: " + nombre + "\nSaldo: " + saldo + "\nCarta de libertad: "
                + cartaLibertad.toString() + "\nCasilla actual: "
                + casillaActual.toString() + "\nNumero de propiedades: "
                + propiedades.size();

        if (!propiedades.isEmpty()) {
            texto += "\nPropiedades:{";

            for (TituloPropiedad t : propiedades) {
                texto += " " + t.toString();
            }

        }
        return texto;
    }
}
