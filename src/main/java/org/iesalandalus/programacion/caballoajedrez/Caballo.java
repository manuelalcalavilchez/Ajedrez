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
    
    //declaracion de atributos
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
        public Caballo (Color color, char columna)
        {
                                
          
  
                    if (columna == 'g' && this.color==Color.BLANCO)
                        this.posicion= new Posicion (1,'g');
                    if (columna == 'g' && this.color==Color.NEGRO)
                        this.posicion= new Posicion (8,'g');
                    if (columna == 'b' && this.color==Color.BLANCO)
                        this.posicion= new Posicion (1,'b');
                    if (columna == 'b' && this.color==Color.NEGRO)
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
                            posicion.setColumna((char) (posicion.getColumna()+1));
                        } catch (Exception e) {System.out.println(e.getMessage());
                        throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()-2);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                        break;
                    case ABAJO_IZQUIERDA:
                        try {
                            posicion.setColumna((char) (posicion.getColumna()-1));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()-2);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case ARRIBA_DERECHA:
                        try {
                             posicion.setColumna((char) (posicion.getColumna()+1));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()+2);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                       
                         break;
                         
                    case ARRIBA_IZQUIERDA:
                        try {
                             posicion.setColumna((char) (posicion.getColumna()-1));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()+2);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case DERECHA_ABAJO:
                        try {
                            posicion.setColumna((char) (posicion.getColumna()+2));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()-1);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                       
                         break;
                    case DERECHA_ARRIBA:
                        try {
                             posicion.setColumna((char) (posicion.getColumna()+2));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                            posicion.setFila(posicion.getFila()+1);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        
                         break;
                    case IZQUIERDA_ABAJO:
                        try {
                             posicion.setColumna((char) (posicion.getColumna()-2));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()-1);
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                         break;
                    case IZQUIERDA_ARRIBA:
                        try {
                             posicion.setColumna((char) (posicion.getColumna()-2));
                        } catch (Exception e) {System.out.println(e.getMessage());
                         throw new OperationNotSupportedException("ERROR:Movimiento no permitido");
                        }
                        try {
                             posicion.setFila(posicion.getFila()+1);
                        } catch (Exception e) {System.out.println(e.getMessage());
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
                        return "El Caballo es de color " + color + ", y  " + posicion ;
                    }
}
