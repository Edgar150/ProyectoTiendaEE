/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.error;

/**
 *
 * @author edgar
 */
public enum Codigo {
    NADA(0),
    ID_DUPLICADO(200),
    ID_VACIO(300),
    CAMPOS_VACIOS(400),
    RELACION_INCORRECTA(500),
    ENTIDAD_NULA (600),
    FORMATO_INCORRECTO(700);
    
    private final int valor;
    
    private Codigo(int valor){
        this.valor=valor;
    }
    
    public int getValor(){
        return valor;
    }
}
