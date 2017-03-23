package Ejercicio;

import java.io.Serializable;

public class Persona implements Serializable{
    
    String nombre;
    String dni;
    String edad;
    
    
    
    public Persona(String nombre, String dni, String edad){
    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
    }
    
    public Persona() {
    
    }
    
    public String imprimir(){
    
    
        return nombre+","+dni+","+edad;
        
                
    }
    
    
}
