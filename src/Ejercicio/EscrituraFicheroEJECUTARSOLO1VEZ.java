package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscrituraFicheroEJECUTARSOLO1VEZ {

    public static void main(String args[]) {
        
        Scanner teclado = new Scanner(System.in);
        String nombre;
      
        try {

            //File f = new File(“Agenda.txt”);
            // el true lo abre al final para escribir
            FileWriter flS = new FileWriter("Agenda.txt", true);
            BufferedWriter fS = new BufferedWriter(flS);
            do {
                System.out.println("Introduce un nombre");
                nombre = teclado.nextLine();
                if (nombre.length() > 0) {
                    System.out.println("dni");
                    String dni = teclado.nextLine();
                    System.out.println("Edad");
                    String edad = teclado.nextLine();
                    fS.write(nombre + "," + dni + "," + edad);
                    fS.newLine();
                }
            } while (nombre.length() > 0);
            //fS.write("");      esto quitando el true, hace que borre el fichero.
            fS.close();
        } catch (IOException e) {
            System.out.println("Error en el fichero");
        }
        
        
        
    }

}
