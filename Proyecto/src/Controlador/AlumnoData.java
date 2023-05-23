package Controlador;

import java.sql.Connection;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos(dni, nombre, apellido, nacimiento, estado) VALUES(?,?,?,?,?)"; ///?? = queda pendiente de carga

        try {
            //para preparar el sql y completarlo, debemos de usar el "PreparedStatement" 
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //como estamos agregando un alumno agreamos un paremetro para 
            // decir que esperamo la clave ingresado.
            //comenzamos a llenar los " ? ? ? ? "
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getNacimiento())); // convertimos el LocalDate, en Date , para poder enviarlo
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate(); // ejecutamos la consulta con "executeUpdate" para las consultas del tipo --> INSERT,UPDATE,DELETE

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) { // obtenemos el ID
                alumno.setId_Alumno(rs.getInt(1)); // Posicion en la tabla, o bien podemos poner el string el nombre de la columna
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            } else {
                System.out.println("Alumno no agregado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET dni=? ,nombre=?, apellido=?, nacimiento=?, estado=? WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getId_Alumno());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Estudiante modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Estudiante no existe o no se Modifico");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    public void bajaAlumno(int id) {
        String sql = "UPDATE alumnos SET estado=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Baja Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo efectuar la Baja");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    public void altaAlumno(int id) {

        String sql = "UPDATE alumnos SET estado=1 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Alta Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo efectuar la Alta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }

    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT idAlumno,dni, nombre, apellido, nacimiento, estado FROM alumnos WHERE idAlumno=?";
        Alumno alumno = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId_Alumno(rs.getInt(1));
                alumno.setDni(rs.getInt(2));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Alumno Inexistente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

        return alumno;

    }

    public void buscarAlumnos(boolean estado, Map misAlumnos) {

        String sql = "SELECT* FROM alumnos WHERE estado =? ORDER BY nombre";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron alumnos con el estado " + estado);
            } else {
                do {
                    Alumno alumno = new Alumno();
                    alumno.setId_Alumno(rs.getInt("idAlumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                    alumno.setEstado(rs.getBoolean("estado"));
                    misAlumnos.put(alumno.getId_Alumno(), alumno);

                } while (rs.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

    }
}

////ex.getMessage

//guardar 
//dar de baja o habilitar alumno
//buscar alumno
//editar alumnos
//buscar alumnos activos
