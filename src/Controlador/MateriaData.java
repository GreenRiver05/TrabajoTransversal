
package Controlador;

import Model.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MateriaData {
     public void guardarMateria(Materia materia){
      
        String sql="INSERT INTO materias( nombre, año, estado) VALUES (?,?,?)";
       try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //operaciones de consulta o modificacion
            //comienzo a llenar los " ? ? ? ? ""
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAnio());
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
    
}
