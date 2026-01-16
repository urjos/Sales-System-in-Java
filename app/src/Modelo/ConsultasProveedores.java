package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasProveedores extends Conexion{
    public boolean Guardar(Proveedores pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO PROVEEDORES (descripcion, direccion, telefono) VALUES (?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getDescripcion());
            ps.setString(2, pro.getDireccion());
            ps.setString(3, pro.getTelefono());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Editar(Proveedores pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE proveedores SET descripcion = ?, direccion = ?, telefono = ? WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getDescripcion());
            ps.setString(2, pro.getDireccion());
            ps.setString(3, pro.getTelefono());
            ps.setInt(4, pro.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Eliminar(Proveedores pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM PROVEEDORES WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Buscar(Proveedores pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM PROVEEDORES WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();
            
            if (rs.next()){
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));
            } else {
            }
        
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
}
