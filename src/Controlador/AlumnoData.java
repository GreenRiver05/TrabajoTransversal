package Controlador;

import java.sql.Connection;
import Model.Alumno;
import java.sql.PreparedStatement;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoData {

    private Connection con;

    public AlumnoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumnos(dni, nombre, apellido, nacimiento, estado) VALUES(?,?,?,?,?)"; ///?? = queda pendiente de carga

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //operaciones de consulta o modificacion
            //comienzo a llenar los " ? ? ? ? ""
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate(); // ejecutamos la consulta INSERT

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
    public void actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumnos SET DNI =?,Nombre=?,Apellido=?,Nacimiento=?,Estados=? WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getId_Alumno());

            ps.close();
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