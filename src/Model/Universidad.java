
package Model;


import Controlador.*;
import java.time.LocalDate;


public class Universidad {

    
    public static void main(String[] args) {
        
        Alumno alu = new Alumno (36546,"Pepe","Urquiza",LocalDate.of(2000, 5, 10),true);
        AlumnoData ad = new AlumnoData();
        ad.guardarAlumno(alu);
    }
    
}
