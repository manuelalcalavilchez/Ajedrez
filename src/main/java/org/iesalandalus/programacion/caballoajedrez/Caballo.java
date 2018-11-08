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
public class Caballo {
    
    //delcaracion de atributos
    private Color color;
    private Posicion posicion;
    
    //metodos getters and setters

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color==null)
            throw new IllegalArgumentException("ERROR: Argumento nulo");
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
         if (posicion==null)
            throw new IllegalArgumentException("ERROR: Argumento nulo");
        this.posicion = posicion;
    }
    //creo un contructor por defecto que cree un caballo negro en posicion 8b. 
    
       public Caballo(Color color, Posicion posicion){
           this.color=Color.NEGRO;
           this.posicion= new Posicion (8,'b');
                      
           
       }
    
}
