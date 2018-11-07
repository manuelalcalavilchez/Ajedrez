/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 * 
 * @author Manuel
 */
public class Posicion 
{
    //declaracion de variables
    private int fila;
    private char columna;
    
    //creo los metodos get y set para los atributos

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila>=1 && fila<=8)
        {
            this.fila = fila;
        }else  
          
        {
            throw new IllegalArgumentException("ERROR:El valor fila esta fuera de su rango válido (1-8)");
        }
    }
    

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        
        if (columna>='a' || columna <='h')
        {
        this.columna = columna;
    } else
            throw new IllegalArgumentException("ERROR:El valor columna esta fuera de su rango válido (a-h)");
        }
    
    //contructor que acepte como parámetros la fila y la columna y los asigne a los atributos si son correctos, 
    //y si no, que lance una excepción indicando el problema.
           
    public Posicion (int fila,char columna)
    {
        
        /*Llamamos al método que permite validar los parametos de fila
         y columna   */
        try {
            setFila(fila);
        } catch (Exception e) {
        }
        try {
          setColumna(columna);  
        } catch (Exception e) {
        }
        
    }

   
       //contructor copia
    public Posicion(Posicion posicion)
    {
       this.fila=posicion.fila;
       this.columna=posicion.columna;   
        
    }
        //metodo equals

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posicion other = (Posicion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }
    
    

}