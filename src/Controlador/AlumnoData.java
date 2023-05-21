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
            } else {
                System.out.println("no agregado");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bajaAlumno(int id) {
        String sql = "UPDATE alumnos SET estado=? WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaAlumno(int id) {

        String sql = "UPDATE alumnos SET estado=? WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("Alumno Inexistente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("No se encontraron alumnos con el estado " + estado);
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
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

////ex.getMessage

//guardar 
//dar de baja o habilitar alumno
//buscar alumno
//editar alumnos
//buscar alumnos activos
