import java.io.IOException;

import prAsignatura.Asignatura;


public class TestNotas {
    
    public static void main(String[] args) {
        Asignatura algebra = new Asignatura("Algebra");
    
        System.out.println(" Lectura de fichero. \n");
        try {
            algebra.leerDatos("datosAlumnos.txt");
        } catch (IOException e) {
            System.out.println("Fichero no existe " + e.getMessage());
        }
        
        System.out.println(algebra);
    }
}
