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
public class Tablero {
    
    //Atributos privados
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    /**
     * Constructor sin argumentos
     */
    public Tablero() {
        inicializar();
    }
    
    /**
     * Se añade las todas las casillas al tablero
     */
    private void inicializar(){
        
        casillas = new ArrayList(Qytetet.MAX_CASILLA);
        
        int numCasillaCarcel = 5 ;
        
        casillas.add(new Casilla(0, TipoCasilla.SALIDA));
         
        casillas.add(new Casilla(1, 000, 
                new TituloPropiedad("Mesas rojas",50, (float) 0.11,150,250)));
        
        
        casillas.add(new Casilla(2, TipoCasilla.SORPRESA));
        
        casillas.add(new Casilla(3, 000,
                new TituloPropiedad("Biblioteca", 65, (float) 0.1, 200, 300)));
        
        casillas.add(new Casilla(4, 000,
                new TituloPropiedad("Cafeteria", 70, (float) 0.12, 350, 350)));        
        
        casillas.add(new Casilla(numCasillaCarcel, TipoCasilla.CARCEL));
        
        casillas.add(new Casilla(6, 000,
                new TituloPropiedad("Secretaria", 85, (float) 0.14, 300, 600)));        
        
        casillas.add(new Casilla(7, TipoCasilla.SORPRESA));
        
        casillas.add(new Casilla(8, 000,
                new TituloPropiedad("Anfiteatro", 60, (float) 0.16, 400, 275)));        
        
        casillas.add(new Casilla(9,000,
                new TituloPropiedad("Aulas pefabricadas", 90, (float) 0.11, 425, 725)));       
        
        casillas.add(new Casilla(10, TipoCasilla.PARKING));
        
        casillas.add(new Casilla(11, 000,
                new TituloPropiedad("Departamento LSI", 100, (float) 0.17, 700, 750)));
        
        casillas.add(new Casilla(12, TipoCasilla.SORPRESA));
        
        casillas.add(new Casilla(13, 000,
                new TituloPropiedad("Departamento DECSAI", 100, (float)0.16, 750, 400)));       
        
        casillas.add(new Casilla(14, 000,
                new TituloPropiedad("Departamento ATC", 90, (float) 0.15, 625, 575)));      
        
        casillas.add(new Casilla(15, TipoCasilla.JUEZ));
        
        casillas.add(new Casilla(16, 000, 
                new TituloPropiedad("Aulario", 150, (float)0.16, 550, 600)));        
        
        casillas.add(new Casilla(17, TipoCasilla.IMPUESTO));
        
        casillas.add(new Casilla(18, 000, 
                new TituloPropiedad("Copisteria", 65, (float)0.18, 475, 625)));        
        
        casillas.add(new Casilla(19, 000,
                new TituloPropiedad("CITIC", 90, (float)0.2, 480, 450)));
         
        carcel = casillas.get(numCasillaCarcel);
                
        
    }
    
    /**
     * Devuelve la casilla donde se encuentra la carcel
     * @return  el objeto casilla de la carcel
     */
    Casilla getCarcel() {
        return carcel;
    }
    boolean esCasillaCarcel(){
        throw new UnsupportedOperationException("sin implementar");
    }
    Casilla obtenerCasillaNumero(int numeroCasilla){
        throw new UnsupportedOperationException("sin implementar");
    }
    Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
        throw new UnsupportedOperationException("sin implementar");
    }
    
    @Override
    public String toString(){
        String salida = "";
        for(int x = 0; x < casillas.size();x++)
            salida += casillas.get(x).toString()+"\n";
        return salida;
    }
    
    
}
