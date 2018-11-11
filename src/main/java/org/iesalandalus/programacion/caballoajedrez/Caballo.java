/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.util.Objects;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * @author Manuel
 */
public class Caballo {
    
    //delcaracion de atributos
    private Color color;
    private Posicion posicion;
    private int opcion;//variable necesaria para realizar operaciones en los metodos
    private char paramColum;//variable necesaria para realizar operaciones en los metodos
    private int movimiento;//variable necesaria para realizar operaciones en el metodo mover
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
    
       public Caballo(){
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
        /*Crea un constructor para la clase que acepte como parámetros el color y la columna inicial.
        La columna inicial debe ser la 'b' o la 'g' 
        (de lo contrario debe lanzar la excepción IllegalArgumentException con un mensaje adecuado) 
        y creara un caballo del color dado y colocado en dicha columna y cuya 
        fila será la 1 si el blanco y la 8 si es el negro.*/
        public Caballo (Color color, Posicion posicion)
        {
                      
                 System.out.println("Introduzca el color deseado para el caballo: 1 Blanco, 2 Negro");
                 opcion= Entrada.entero();
                 if (opcion !=1 || opcion!=2)
                     throw new IllegalArgumentException("ERROR: Valor no valido para la seleccion de color");
                 if (opcion==1)
                 this.color=Color.BLANCO;
                 else   
                 this.color=Color.NEGRO;
           
            
            System.out.println("Introduzca la columna deseada ( debe ser 'g' o 'b'");
            paramColum=Entrada.caracter();
            
            if (paramColum!='g' || paramColum!='d')
                    throw new IllegalArgumentException("ERROR:Esa columna es erronea");
  
                    if (paramColum == 'g' && this.color==Color.BLANCO)
                        this.posicion= new Posicion (1,'g');
                    if (paramColum == 'g' && this.color==Color.NEGRO)
                        this.posicion= new Posicion (8,'g');
                    if (paramColum == 'b' && this.color==Color.BLANCO)
                        this.posicion= new Posicion (1,'b');
                    if (paramColum == 'b' && this.color==Color.NEGRO)
                        this.posicion= new Posicion (8,'b');
                                       
        }
        
        //contructor copia
        public Caballo(final Caballo cab)
        {
       if (cab==null)
            throw new IllegalArgumentException("ERROR: Copiando objeto vacio");
       this.color=cab.color;
       this.posicion=cab.posicion;   
        
        }    
        
        //implemento método mover
        public void mover(Direccion direccion)throws OperationNotSupportedException { 
		if (direccion == null) {
			throw new IllegalArgumentException("La dirección no puede ser nula.");
		}
		
                switch(direccion){
                    case ABAJO_DERECHA:
                        try {
                            posicion.setColumna(posicion.getColumna()+1);
                        } catch (Exception e) {
                        throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()-2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                        break;
                    case ABAJO_IZQUIERDA:
                        try {
                            posicion.setColumna(posicion.getColumna()-1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()-2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case ARRIBA_DERECHA:
                        try {
                             posicion.setColumna(posicion.getColumna()+1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()+2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                       
                         break;
                         
                    case ARRIBA_IZQUIERDA:
                        try {
                             posicion.setColumna(posicion.getColumna()-1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()+2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case DERECHA_ABAJO:
                        try {
                            posicion.setColumna(posicion.getColumna()+2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()-1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                       
                         break;
                    case DERECHA_ARRIBA:
                        try {
                             posicion.setColumna(posicion.getColumna()+2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()+1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case IZQUIERDA_ABAJO:
                        try {
                             posicion.setColumna(posicion.getColumna()-2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()-1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                         break;
                    case IZQUIERDA_ARRIBA:
                        try {
                             posicion.setColumna(posicion.getColumna()-2);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()+1);
                        } catch (Exception e) {
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                       
                         break;      
                                                        
                    }
                 
                } 
                //implemento metodo equals. Solo Color y Posicion, ya que las otras variables no definen el objeto
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
                        final Caballo other = (Caballo) obj;
                        if (this.color != other.color) {
                            return false;
                        }
                        if (!Objects.equals(this.posicion, other.posicion)) {
                            return false;
                        }
                        return true;
                        
                        
                        
                    }
                    //implemento el método toString
                    @Override
                    public String toString() {
                        return "El Caballo es de color " + color + ", y está en la posición= " + posicion ;
                    }
                                }
