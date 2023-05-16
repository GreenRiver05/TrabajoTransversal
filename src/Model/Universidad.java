
package Model;


import Controlador.AlumnoData;
import java.time.LocalDate;


public class Universidad {

    
    public static void main(String[] args) {
        
        Alumno alu = new Alumno (321,"Pepito","Urquiza",LocalDate.of(2000, 5, 10),true);
        AlumnoData ad = new AlumnoData();
        ad.guardarAlumno(alu);
    }
    
}
