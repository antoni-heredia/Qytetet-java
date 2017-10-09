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
    
    
    
    
    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    private void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public int getNumCasas() {
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
    
}
