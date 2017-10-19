/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author jo_se
 */
public class Casilla {
    private int numeroCasilla;

    
    private int coste;
    private int numHoteles;
    private int numCasas;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;

    
    //construtor para casillas que no son calle
    public Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = 0;
        this.numHoteles = 0;
        this.numCasas = 0;
        this.titulo = null;
        
    }
    //Contructor para casillas que son calle
    public Casilla(int numeroCasilla, int coste, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.titulo = titulo;
        this.tipo = TipoCasilla.CALLE;
        this.numHoteles = 0;
        this.numCasas = 0;
    }
    
    void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    int getNumeroCasilla() {
        return numeroCasilla;
    }

    int getCoste() {
        return coste;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    int getNumCasas() {
        return numCasas;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }
    @Override
    public String toString(){
        String stringCasilla = "Casilla{\nNumero Casilla=" + numeroCasilla + "\nTipo="
                    + tipo + "\nCoste=" + coste;
        if (tipo == TipoCasilla.CALLE){
            stringCasilla +=   "\nNumero Casas=" + numCasas 
                    + "\nNumero Hoteles=" + numHoteles + "\n" + titulo.toString();
        }
        
        stringCasilla +=  "\n}";
        
        return stringCasilla;
    }
    TituloPropiedad asignarPropietario(Jugador jugador){
        
        return null;
    }
    int cancelarHipoteca(){
    
        throw new UnsupportedOperationException("sin implementar");
    }
    int calcularValorHipoteca(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int cobrarAlquiler(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int edificarCasa(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int edificarHotel(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean estadoHipoteca(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int getCosteHipoteca(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int getPrecioEdificar(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int hipotecar(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int precioTotalComprar(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean calcularHipoteca(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean sePuedeEdificarCasa(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean sePuedeEdificarHotel(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean soyEdificable(){
        throw new UnsupportedOperationException("sin implementar");
    }
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("sin implementar");
    }
    int venderTitulo(){
        throw new UnsupportedOperationException("sin implementar");
    }
    
    private void asignarTituloPropiedad(){
        throw new UnsupportedOperationException("sin implementar");
    }
    
    
    
}
