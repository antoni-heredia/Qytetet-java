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
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecado;
    private int  alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    
    public TituloPropiedad(String nombre, boolean hipotecado, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar){
        this.nombre = nombre;
        this.hipotecado = hipotecado;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }
    //Constructor sin necesidad de decir si esta hipotecada, ya que por defecto sera false
    public TituloPropiedad(String nombre,int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar){
        this.nombre = nombre;
        this.hipotecado = false;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }
    
    //Constructor indicando solo el nombre, los demas valores estaran puestos al minimo
    public TituloPropiedad(String nombre){
        this.nombre = nombre;
        this.hipotecado = false;
        this.alquilerBase = 50;
        this.factorRevalorizacion = (float) 0.1;
        this.hipotecaBase = 150;
        this.precioEdificar = 250;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecado() {
        return hipotecado;
    }

    public int getAlquilerBase() {
        return alquilerBase;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }
    
    public void setHipotecado(boolean hipotecado) {
        this.hipotecado = hipotecado;
    }
    
    @Override
    public String toString(){
        return "TituloPropiedad{" + "nombre=" + nombre +"\n hipotecado=" 
                + hipotecado +"\n Factor de Revalorizacion=" + factorRevalorizacion
                + "\n Alquiler Base="+ alquilerBase+ "\n Hipoteca Base=" 
                + hipotecaBase + "\n Precio Edificar= " + precioEdificar + "}";
    }
    
}
