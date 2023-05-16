package Controlador;

import Conexion.Conexion;
import Model.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoData {

    private Connection con = Conexion.getConexion();

    public AlumnoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumnos(DNI, Nombre, Apellido, Nacimiento, Estados) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getNacimiento()));
            ps.setBoolean(5, alumno.getEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId_Alumno(rs.getInt(1));
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
            ps.setBoolean(5, alumno.getEstado());
            ps.setInt(6, alumno.getId_Alumno());

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

////ex.getMessage
//guardar 
//borrar
//buscar alumno
//buscar alumnos
