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
    boolean actualizarPosicion(Casilla casilla) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     * Compra un titulo de la propiedad
     *
     * @return
     */
    boolean comprarTitulo() throws UnsupportedOperationException{
        //TODO : Implementar el metodo
        throw new UnsupportedOperationException("sin implementar");
    }

    /**
     *
     * @return
     */
    Sorpresa devolverCartaLibertad() throws UnsupportedOperationException{
        //TODO : Implementar el metodo
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla 
     */
    void  irACarcel(Casilla casilla) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param Cantidad 
     */
    void modificarSaldo(int Cantidad) throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");        
    }
    
    /**
     * 
     * @return 
     */
    int obtenerCapital() throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param hipotecadas
     * @return 
     */
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecadas) throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param cantidad 
     */
    void pagarCobrarPorCasaYHotel(int cantidad) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");        
    }
    
    /**
     * 
     * @param cantidad
     * @return 
     */
    boolean pagarLibertad(int cantidad) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoEdificarCasa(Casilla casilla) throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }

    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoEdificarHotel(Casilla casilla) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoHipotecar(Casilla casilla) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoPagarHipoteca(Casilla casilla) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    boolean puedoVenderPropiedad(Casilla casilla)throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param carta
     * @return 
     */
    boolean tengoCartaLiberdad(Sorpresa carta) throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla 
     */
    void venderPropiedad(Casilla casilla) throws  UnsupportedOperationException{
       //TODO 
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @return 
     */
    private int cuantasCasasHotelTengo() throws UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    
    /**
     * 
     * @param casilla 
     */
    private void eliminarDeMisPropiedades(Casilla casilla) throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * 
     * @param casilla
     * @return 
     */
    private boolean esDeMiPropiedad(Casilla casilla) throws UnsupportedOperationException{
        //TODO
            throw new UnsupportedOperationException("sin implementar");
    } 
    
    /**
     * 
     * @param cantidad
     * @return 
     */
    private boolean tengoSaldo(int cantidad) throws  UnsupportedOperationException{
        //TODO
        throw new UnsupportedOperationException("sin implementar");
    }
    
    /**
     * Devuelve la informacion del jugador en forma de string
     *
     * @return
     */
    @Override
    public String toString() {

        String texto = "Nombre: " + nombre + "\nSaldo: " + saldo ;
        if(cartaLibertad != null)
            texto += "\nCarta de libertad: " + cartaLibertad.toString();
        if(casillaActual != null)
            texto += "\nCasilla actual: " + casillaActual.toString();
        if(propiedades != null){
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
