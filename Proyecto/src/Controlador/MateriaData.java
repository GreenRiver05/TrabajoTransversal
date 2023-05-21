package Controlador;

import Model.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materias( nombre, año, estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //operaciones de consulta o modificacion
            //comienzo a llenar los " ? ? ? ? ""

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate(); // ejecutamos la consulta INSERT

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) { // obtenemos el ID

                materia.setId_Materia(rs.getInt(1));
            } else {
                System.out.println("Materia no  agregada");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarMateria(Materia materia) {
        //String sql = "UPDATE materias SET nombre = ?, anio = ?, WHERE idmateria = ?";
        //String sql = "UPDATE `materias` SET idMaterias= ? , nombre= ? ,anio = ?, estado = ? WHERE 1";
        String sql = "UPDATE materias SET nombre=?,año=?,estado=? WHERE idMaterias=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, materia.getNombre());
//            ps.setInt(2, materia.getAnio());
//            ps.setInt(3, materia.getId_Materia());
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getId_Materia());

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no se modifico.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar una materia.");
        }
    }

    public void bajaMateria(int id) {
        String sql = "UPDATE materias SET estado=? WHERE idMaterias=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaMateria(int id) {
        String sql = "UPDATE materias SET estado=? WHERE idMaterias=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia buscarMateria(int id) {
        String sql = "SELECT idMaterias, nombre, año, estado FROM materias WHERE idMaterias=?";
        Materia materia = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setId_Materia(rs.getInt(1));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt(3));
                materia.setEstado(rs.getBoolean("estado"));
            } else {
                System.out.println("Materia Inexistente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materia;

    }

    public ArrayList<Materia> buscarMaterias(boolean estado) {
        ArrayList<Materia> misMaterias = new ArrayList();
        String sql = "SELECT* FROM materias WHERE estado =?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontraron materias con el estado " + estado);
            } else {
                do {
                    Materia materia = new Materia();
                    materia.setId_Materia(rs.getInt("idMaterias"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnio(rs.getInt("año"));
                    materia.setEstado(rs.getBoolean("estado"));
                    misMaterias.add(materia);

                } while (rs.next());
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misMaterias;

    }
}
