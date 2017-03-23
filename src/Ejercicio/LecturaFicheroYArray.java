package Ejercicio;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaFicheroYArray {
    
    
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
    
        FileReader flS = null;
        try {
            Scanner teclado = new Scanner(System.in);
            flS = new FileReader("Agenda.txt");
            BufferedReader fS = new BufferedReader(flS);
            
            String texto;
            String nombre;
            String dni;
            String edad;
            Persona arrayPersonas[] = new Persona[5];
            
            
            //lectura de la primera linea para que entre o no en el for
            texto = fS.readLine();
            
          
      
            for(int i=0;texto!=null;i++){
                StringTokenizer st = new StringTokenizer(texto,",");
                
                
                //System.out.println(i);    
                
                nombre = st.nextToken();
                dni = st.nextToken();
                edad = st.nextToken();
                
                
            Persona p = new Persona(nombre,dni,edad);
            //p.imprimir();
            arrayPersonas[i] = p;
            
            texto = fS.readLine();
            
            
            }
            
            
            
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ficheroObjetos.txt"));
            
            //escribo el array entero en el txt este, se podria escribir persona a persona pero bueno...
            oos.writeObject(arrayPersonas);
            
            oos.close();
            
            
            //voy a ver si está bien escrito para ello voy a leer el fichero
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ficheroObjetos.txt"));
            
            //aqui hay 2 modos, si sabes que tipo de objeto vas a leer haces esto
            
            //PRIMER MODO
            Persona aux[] = (Persona[]) ois.readObject();
            
            System.out.println(aux[0].imprimir());
            System.out.println(aux[1].imprimir());
            System.out.println(aux[2].imprimir());
            System.out.println(aux[3].imprimir());
            System.out.println(aux[4].imprimir());
            
            
            
            //SEGTUNDO MODO
            /*si no sabes el tipo de objeto que vas a leer haces esto
            
            Object aux = ois.readObject();
            
            if(aux instanceof Persona[]){
            
               Persona ar[] = (Persona[]) aux;
            System.out.println(ar[0].imprimir());
            System.out.println(ar[1].imprimir());
            System.out.println(ar[2].imprimir());
            System.out.println(ar[3].imprimir());
            System.out.println(ar[4].imprimir());
           
            
            }
            */
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaFicheroYArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                flS.close();
            } catch (IOException ex) {
                Logger.getLogger(LecturaFicheroYArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    
    
    }
    
    
    
    
    
    
}
