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
        titulo.setCasilla(this);
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
    public String toString() {
        String stringCasilla = "Casilla{\nNumero Casilla=" + numeroCasilla + "\nTipo="
                + tipo + "\nCoste=" + coste;
        if (tipo == TipoCasilla.CALLE) {
            stringCasilla += "\nNumero Casas=" + numCasas
                    + "\nNumero Hoteles=" + numHoteles + "\n" + titulo.toString();
        }

        stringCasilla += "\n}";

        return stringCasilla;
    }

    TituloPropiedad asignarPropietario(Jugador jugador) {

        return null;
    }

    int cancelarHipoteca() {

        throw new UnsupportedOperationException("sin implementar");
    }

    int calcularValorHipoteca() {
        int hipotecaBase = titulo.getHipotecaBase();
        int valor =  hipotecaBase + (int)(numCasas * 0.5 * hipotecaBase + numHoteles * hipotecaBase);
        
        return valor;
    }

    int cobrarAlquiler() {
        int costeTotal = titulo.getAlquilerBase();
        costeTotal += numCasas * 0.5 + numHoteles * 2;
        titulo.cobrarAlquiler(costeTotal);

        return costeTotal;
    }

    int edificarCasa() {
        setNumCasas(numCasas + 1);
        return titulo.getPrecioEdificar();
    }

    int edificarHotel() {
        setNumCasas(numHoteles + 1);
        return titulo.getPrecioEdificar();
    }

    /**
     * Se mira si la casilla esta hipotecada
     *
     * @return devuelve true si lo esta y false si no lo esta.
     */
    boolean estaHipoteca() {
        return titulo.getHipotecada();
    }

    int getCosteHipoteca() {
        throw new UnsupportedOperationException("sin implementar");
    }

    int getPrecioEdificar() {
        return titulo.getPrecioEdificar();
    }

    int hipotecar() {
        titulo.setHipotecada(true);
        int cantidadRecibida = this.calcularValorHipoteca();
        
        
       return cantidadRecibida;
    }

    int precioTotalComprar() {
        throw new UnsupportedOperationException("sin implementar");
    }

    boolean calcularHipoteca() {
        throw new UnsupportedOperationException("sin implementar");
    }

    boolean sePuedeEdificarCasa() {
        return (numCasas < 4);
    }

    boolean sePuedeEdificarHotel() {
        return (numHoteles < 4);
    }

    /**
     *
     * @return
     */
    boolean soyEdificable() {
        return (tipo == TipoCasilla.CALLE);
    }

    boolean tengoPropietario() {
        return titulo.tengoPropietario();
    }

    /**
     *
     * @return
     */
    boolean propietarioEncarcelado() {
        return titulo.propietarioEncarcelado();
    }

    int venderTitulo() {
        this.setNumCasas(0);
        this.setNumHoteles(0);
        titulo.setPropietario(null);
        int precioCompra = coste + (numCasas+numHoteles)*titulo.getPrecioEdificar();
        int precioVenta = (int) (precioCompra+precioCompra*titulo.getFactorRevalorizacion());
        return precioVenta;
    }

    private TituloPropiedad asignarTituloPropiedad(Jugador jugador) {
        titulo.setPropietario(jugador);
        return titulo;
    }

}
