package Model;

import AccesoADatos.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Universidad {

    public static void main(String[] args) {

//--------------------------------------------------------------- ALUMNO --------------------------------------------------------------- 

//................ CARGAR ALUMNO ................  FUNCA
//        Alumno alu = new Alumno (36546968,"Pepe","Urquiza",LocalDate.of(2000, 5, 10),true);
//        AlumnoData ad = new AlumnoData();
//        ad.guardarAlumno(alu);


//................ BUSCAR ALUMNO ................  FUNCA
//        AlumnoData ad = new AlumnoData();
//        System.out.println("Estudiante : " + ad.buscarAlumno(50));


//................ BUSCAR ALUMNO POR DNI ................  FUNCA
//        AlumnoData ad = new AlumnoData();
//        System.out.println("Estudiante : " + ad.buscarAlumnoDNI(38554946));


//................ LISTAR ALUMNOS ................   FUNCA
///        AlumnoData ad = new AlumnoData();
//        System.out.println("ESTUDIANTES:");
//        for (Alumno alum : ad.listarAlumnos(false)) {
//            System.out.println(alum);
//        }


//................ MODIFICAR ALUMNO ................ FUNCA
////        Alumno alu = new Alumno(89,38554946, "Agustina", "Rojos", LocalDate.of(2002, 1, 5), true);
//        AlumnoData ad = new AlumnoData();
//        ad.modificarAlumno(alu);


//................ BAJA Y ALTA ALUMNO ................ FUNCAN
//        AlumnoData ad = new AlumnoData();
//        ad.bajaAlumno(15);
//        ad.bajaAlumno(21);
//        ad.bajaAlumno(25);
//        ad.altaAlumno(1);
//        ad.altaAlumno(2);

//--------------------------------------------------------------- MATERIA --------------------------------------------------------------- 

//................ GUARDAR MATERIA ................ FUNCA
//        Materia mat = new Materia("Video Juego", 2, true);
//        MateriaData md = new MateriaData();
//        md.guardarMateria(mat);


//................ BUSCAR MATERIA ................ FUNCA
//        MateriaData md = new MateriaData();
//        System.out.println("Materia : " + md.buscarMateria(89));


//................ MODIFICAR MATERIA ................ FUNCA
//        Materia mat = new Materia(99,"Historia", 1, false);
//        MateriaData md = new MateriaData();
//        md.modificarMateria(mat);


//................ BAJA Y ALTA MATERIA ................ FUNCA
//     MateriaData md = new MateriaData();
//     md.bajaMateria(99);
//     md.bajaMateria(5);
//     md.bajaMateria(39);
//     md.altaMateria(1);
//     md.altaMateria(2);


//................ LISTAR MATERIAS ................ FUNCA
//       MateriaData md = new MateriaData();
//       for (Materia mat : md.listarMaterias(true)) {
//            System.out.println(mat);
//        }

////--------------------------------------------------------------- INSCRIPCION --------------------------------------------------------------- 

//................ GUARDAR INSCRIPCION ................  FUNCA
//        Alumno alu = new Alumno(36564111, "Coquito", "Palmera", LocalDate.of(2000, 4, 1), true);
//        AlumnoData ad = new AlumnoData();
//        ad.guardarAlumno(alu);
//        
//        Materia mat = new Materia("Algebra", 2, true);
//        MateriaData md = new MateriaData();
//        md.guardarMateria(mat);
//        
//        
//        Inscripcion insc = new Inscripcion(0, alu, mat);
//        InscripcionData id = new InscripcionData();
//        id.guardarInscripcion(insc);


//................ OBTENER INSCRIPCIONES ................  FUNCA
//        InscripcionData id = new InscripcionData();
//        System.out.println("INSCRIPCIONES : \n");
//        for (Inscripcion insc : id.obtenerInscripciones()) {
//            System.out.println(insc.toString());
//        }


//................ OBTENER INSCRIPCIONES POR ALUMNO ................ FUNCA
//        InscripcionData id = new InscripcionData();
//        for (Inscripcion insc : id.obtenerInscripcionesPorAlumno(1)) {
//            System.out.println(insc.toString());
//        }


//................ OBTENER MATERIAS CURSADAS ................ FUNCA
//        InscripcionData id = new InscripcionData();
//        for ( Inscripcion insc : id.obtenerMateriasCursadas(1)){
//            System.out.println(insc.toString1());
//        }


//................ OBTENER MATERIAS NO CURSADAS ................ FUNCA
//        InscripcionData id = new InscripcionData();
//        int aux = 0;
//        for (Inscripcion insc : id.obtenerMateriasNoCursadas(1)) {
//            if (aux == 0) {
//                System.out.println("El Alumno: " + insc.getAlumno().getNombre() + " " + insc.getAlumno().getApellido() + " no se encuentra inscripto en las Materias:");
//                aux++;
//            }
//            System.out.println(insc.toString2());
//        }


////................ BORRAR INSCRIPCION MATERIA ALUMNO ................ FUNCA
//        InscripcionData id = new InscripcionData();
//        id.borrarInscripcionMateriaAlumno(46);


//................ ACTUALIZAR NOTA ................  FUNCA
//        InscripcionData id = new InscripcionData();
//        id.actualizarNota(9, 16);
//       

//................ OBTENER  ALUMNA X MATERIA ................  FUNCA
//        InscripcionData id = new InscripcionData();
//        int aux = 0;
//        for (Inscripcion insc : id.obtenerAlumnosXMateria(1)) {
//            if (aux == 0) {
//                System.out.println("Los alumnos que se encuentran inscripto a " + insc.getMateria().getNombre() + " de " + insc.getMateria().getAnio() + " año son:");
//                aux++;
//            }
//            System.out.println(insc.toString3());
//        }
    }
}
