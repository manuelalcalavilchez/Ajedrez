package org.iesalandalus.programacion.caballoajedrez;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    
    private static Caballo caballo;
    private static Posicion posicion;
    private static Color color;
   
	
	public static void main(String[] args) {
            // TODO code application logic here
        int opcion;
        
        do
        {
            //Mostramos el menú con las distintas opciones del programa
            mostrarMenu();
            
            //Pedimos al usuario que elija una opción
            opcion=elegirOpcion();
            
            //En función de la opción elegida ejecutamos uno u otro método
            
            ejecutarOpcion(opcion);
        }while (opcion!=5);
        
        System.out.println("Programa finalizado por el usuario");
        
        
    }//llave del main
            //Método que nos muestra las opciones
        private static void mostrarMenu(){                   
            System.out.println("1-Crear caballo por defecto");
            System.out.println("2-Crear caballo de un color ( blanco o negro)");
            System.out.println("3-Crear caballo en de un color en una columna inicial válida");
            System.out.println("4-Mover el caballo");
            System.out.println("5-Salir");
                                        }
          //Método que elige y valida la opcion del usuario
        private static int elegirOpcion()
        {
            int opcion;
            do{
            System.out.println("Elija una opciones: ");
            opcion= Entrada.entero();
            } while (opcion<0 || opcion>5);
            
            return opcion;
        }
        
        private static void ejecutarOpcion(int opcion)
        {
            
            switch(opcion){
                case 1:
                    crearCaballoDefecto();
                    break;
                case 2:
                    crearCaballoDefectoColor();//requerira cear el método elegirColor para escoger el color del ENUM
                    break;
                case 3:
                    crearCaballoColorPosicion(); /*requerira el método elegirColor para escoger el color del ENUM,
                                                  y el método elegirCulumnaInicial*/
                    break;
                case 4:
                    mostrarMenuDirecciones();
                    break;
            }//llave fin de switch
        }//llave fin de metodo ejecutarOpcion()
        
           /*Opcion 1, crear un caballo por defecto */
        private static void crearCaballoDefecto()
        {
            caballo = new Caballo();
           System.out.println("--------------------------------------");
           System.out.println(caballo);   
           System.out.println("--------------------------------------");
        }
     
          /*opcion 2 ejegir el color del caballo y devuelve la posision
        dependiendo del color escogido*/  
        private static void crearCaballoDefectoColor(){
           Color color;
           color=elegirColor();
            try {
                caballo = new Caballo (color);
            } catch (Exception e) { System.out.println(e.getMessage());
            }
            
            
    
           System.out.println("--------------------------------------");
           System.out.println("El caballo es de color "+ color);
           System.out.println(" caballo.getColor   " + caballo.getColor());
           System.out.println("caballo.getPosicion  "+ caballo.getPosicion());
            System.out.println(caballo);
           System.out.println("--------------------------------------");
            }
        
                  
        //metodo complemtentario de la opcion 2, para elegir el color
        private static Color elegirColor(){
            int selec;
            Color color=Color.BLANCO;
            
            do{
                System.out.println("Selecione un color: 1-Negro  2-Blanco");
                selec=Entrada.entero();
            }while(selec<1 || selec>2);
            switch(selec)
            {
                case 1:
                    color=Color.NEGRO;
                break;
                case 2:
                    color=Color.BLANCO;
                break;               
                
            }
            return color;
        }//llave de elegircolor()
        
        public static void crearCaballoColorPosicion(){
        Color color;
        char columna;
        color= elegirColor();
        columna=elegirColumnaInicial();
            try {
                 caballo = new Caballo (color,columna);
            } catch (IllegalArgumentException e) { 
            
            System.out.println("ERROR: No se ha creado el caballo.");
            System.out.println(e.getMessage());       
            }
  
          

           System.out.println("--------------------------------------");
           System.out.println("El caballo es de color "+ color);
           System.out.println("la columna es "+ columna);                    
           System.out.println(" caballo.getcolor   " + caballo.getColor());
           System.out.println("caballo.getPosicion  "+ caballo.getPosicion());
           
           System.out.println(caballo);
          // System.out.println(" la columna es la " + posicion.getColumna() );
          //System.out.println(" la columna es la " + posicion.getFila() );
           System.out.println("--------------------------------------");
            
        }//llave fin de metodo crearCaballoColorPosicion
        
        public static char elegirColumnaInicial(){
            char columna;
            do{
            System.out.println("Introduzca la columna de partida deseada(g o b)");
            columna=Entrada.caracter();
            }while (columna !='g' && columna !='b');
            return columna;
        }//llave fin de metodo elegirColumna
        
        
        public static void mostrarMenuDirecciones(){
        try {
            int movimiento;
            do{
                System.out.println("Elija donde desea mover el caballo");
                System.out.println("1. Arriba y Derecha");
                System.out.println("2. Arriba e Izquierda");
                System.out.println("3. Derecha y Abajo");
                System.out.println("4. Derecha y Arriba");
                System.out.println("5. Abajo e Izquierda");
                System.out.println("6. Abajo y Derecha");
                System.out.println("7. Izquierda y Arriba");
                System.out.println("8. Izquierda y Abajo");
                
                movimiento=Entrada.entero();
            } while( movimiento < 1 || movimiento>8);
            
            switch(movimiento){
                case 1:
                    caballo.mover(Direccion.ARRIBA_DERECHA);
                    break;
                case 2:
                    caballo.mover(Direccion.ARRIBA_IZQUIERDA);
                    break;
                case 3:
                    caballo.mover(Direccion.DERECHA_ABAJO);
                    break;
                case 4:
                    caballo.mover(Direccion.DERECHA_ARRIBA);
                    break;
                case 5:
                    caballo.mover(Direccion.ABAJO_IZQUIERDA);
                    break;
                case 6:
                    caballo.mover(Direccion.ABAJO_DERECHA);
                    break;
                case 7:
                    caballo.mover(Direccion.IZQUIERDA_ARRIBA);
                    break;
                case 8:
                    caballo.mover(Direccion.IZQUIERDA_ABAJO);
                    break;
            }
        } catch (OperationNotSupportedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         System.out.println("--------------------------------------");
           System.out.println("El caballo es de color "+ caballo.getColor());
          
           System.out.println(caballo.getPosicion());
           System.out.println("--------------------------------------");
           System.out.println(caballo);
          // System.out.println(" la columna es la " + columna  );
        
        }
        
             
}//llave del MainAPP