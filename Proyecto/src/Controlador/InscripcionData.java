package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void inscribirAlumno(Inscripcion inscripcion) {

        String sql = "INSERT INTO inscripciones (idAlumnos, idMaterias, Nota ) VALUES(?, ?, ?) ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getId_Alumno());
            ps.setInt(2, inscripcion.getMateria().getId_Materia());
            ps.setDouble(3, inscripcion.getNota());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setId_Inscripcion(rs.getInt(1));
            } else {
                System.out.println("No se pudo efectuar inscripcion");
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarInscripcion(int nota, int id) {
        String sql = "UPDATE  inscripciones  SET  Nota =? WHERE idInscripcion =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void borrarInscripcion(int id) {

        String sql = "DELETE FROM inscripciones WHERE idInscripcion =?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro inscripcion");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Inscripcion> buscarInscripcionAlumno(int id) {
        Inscripcion inscripcion = null;
        Alumno alumno = null;
        Materia materia = null;
        ArrayList<Inscripcion> misInscripciones = new ArrayList();
        String sql = "SELECT idInscripcion, inscripciones.idAlumnos, inscripciones.idMaterias, nota\n"
                + "FROM alumnos, materias, inscripciones\n"
                + "WHERE alumnos.IdAlumno = inscripciones.idAlumnos\n"
                + "AND materias.idMaterias = inscripciones.idMaterias\n"
                + "AND alumnos.IdAlumno =?";//idinscriopcion
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No hay inscripciones con ese IdAlumno");
            } else {
                do {
                    inscripcion = new Inscripcion();
                    alumno = new Alumno();
                    materia = new Materia();
                    
                    inscripcion.setId_Inscripcion(rs.getInt("idInscripcion"));
                    alumno.setId_Alumno(id);
                    materia.setId_Materia(rs.getInt("idMaterias"));
                    inscripcion.setNota(rs.getInt("nota"));//idalumno y idmateria
                    misInscripciones.add(inscripcion);

                } while (rs.next());
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misInscripciones;

    }
}
