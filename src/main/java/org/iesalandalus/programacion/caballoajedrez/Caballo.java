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
       
       //constructor para la clase que acepte como parámetro 
       //el color que creará un caballo de dicho color cuya posición será 
       //'1b' si es blanco o '8b' si es negro.
       public Caballo (Color color)
{
        //comprobar que el parámetro no sea null, ya que estás pasando un objeto.
        if (color==null)
            throw new IllegalArgumentException("Error:El parametro es null");
                    
        //comprobar si es de color blanco, asignarle la posición 1b, y si no, la posición 8b.
        if (color==Color.BLANCO)
            this.posicion= new Posicion (1,'b');
                    else
            this.posicion=new Posicion (8,'b');

}
    
}
