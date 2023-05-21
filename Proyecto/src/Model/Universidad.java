package Model;

import Controlador.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Universidad {

    public static void main(String[] args) {

//--------------------------------------------------------------- ALUMNO --------------------------------------------------------------- 
//................ CARGAR ALUMNO ................  
//        Alumno alu = new Alumno (36546,"Pepe","Urquiza",LocalDate.of(2000, 5, 10),true);
//        AlumnoData ad = new AlumnoData();
//        ad.guardarAlumno(alu);
//................ MODIFICAR ALUMNO ................ 
//        Alumno alu = new Alumno(21,38554946, "Agustina", "Rojos", LocalDate.of(2002, 1, 5), true);
//        AlumnoData ad = new AlumnoData();
//        ad.actualizarAlumno(alu);
//................ BUSCAR ALUMNO ................ 
//        AlumnoData ad = new AlumnoData();
//        System.out.println("Estudiante : " + ad.buscarAlumno(2));
//................ BUSCAR ALUMNOS ................ 
//
//        AlumnoData ad = new AlumnoData();
//        Map<Integer, Alumno> misAlumnos = new HashMap();
//        ad.buscarAlumnos(true, misAlumnos);
//        if (!misAlumnos.isEmpty()) {
//            System.out.println("ESTUDIANTES:");
//            for (Map.Entry<Integer, Alumno> alumno : misAlumnos.entrySet()) {
//                System.out.println(alumno.getValue());
//            }
//        }
//................ BAJA Y ALTA ALUMNO ................ 
//        AlumnoData ad = new AlumnoData();
//        ad.bajaAlumno(2);
//        ad.bajaAlumno(3);
//        ad.bajaAlumno(1);
//        ad.altaAlumno(3);
//        ad.altaAlumno(2);
//--------------------------------------------------------------- MATERIA --------------------------------------------------------------- 
//................ CARGAR MAERIA ................ 
//        Materia mat = new Materia("Video Juego", 2, true);
//        MateriaData md = new MateriaData();
//        md.guardarMateria(mat);
//................ MODIFICAR MATERIA ................ 
//        Materia mat = new Materia(38,"VideoGame", 1, false);
//        MateriaData md = new MateriaData();
//        md.modificarMateria(mat);
//................ BAJA Y ALTA MATERIA ................ 
//     MateriaData md = new MateriaData();
//     md.bajaMateria(1);
//     md.bajaMateria(2);
//     md.bajaMateria(3);
//     md.altaMateria(38);
//     md.altaMateria(5);
//................ BUSCAR MATERIA ................
//        MateriaData md = new MateriaData();
//        System.out.println("Materia : " + md.buscarMateria(1));
//................ BUSCAR MATERIAS ................
//       MateriaData md = new MateriaData();
//       for (Materia mat : md.buscarMaterias(false)) {
//            System.out.println(mat);
//        }
////--------------------------------------------------------------- INSCRIPCION --------------------------------------------------------------- 
//................ CARGAR INSCRIPCION ................  
//        Alumno alu = new Alumno(36564546, "Fernando", "Sosa", LocalDate.of(2000, 4, 1), true);
//        AlumnoData ad = new AlumnoData();
//        ad.guardarAlumno(alu);
//        
//        Materia mat = new Materia("Video Juego", 2, true);
//        MateriaData md = new MateriaData();
//        md.guardarMateria(mat);
//        
//        
//        Inscripcion insc = new Inscripcion(0, alu, mat);
//        InscripcionData id = new InscripcionData();
//        id.inscribirAlumno(insc);
//................ MODIFICAR INSCRIPCION ................  
//        InscripcionData id = new InscripcionData();
//        id.modificarInscripcion(5, 5);
//................ Eliminar INSCRIPCION ................  
//    InscripcionData id = new InscripcionData();
//    id.borrarInscripcion(44);
//................ BUSCAR INSCRIPCIONES ALUMNO ................
        InscripcionData id = new InscripcionData();
        for (Inscripcion insc : id.buscarInscripcionAlumno(2)) {
            System.out.println(insc);
        }
        
    }

}
