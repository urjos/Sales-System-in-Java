package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasClientes extends Conexion{
    public boolean Guardar(Clientes cli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO CLIENTES (descripcion, direccion, telefono, ruc) VALUES (?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDescripcion());
            ps.setString(2, cli.getDireccion());
            ps.setString(3, cli.getTelefono());
            ps.setString(4, cli.getRuc());
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
    
    public boolean Editar(Clientes cli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE clientes SET descripcion = ?, direccion = ?, telefono = ?, ruc = ? WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDescripcion());
            ps.setString(2, cli.getDireccion());
            ps.setString(3, cli.getTelefono());
            ps.setString(4, cli.getRuc());
            ps.setInt(5, cli.getId());
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
    
    public boolean Eliminar(Clientes cli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
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
    
    public boolean Buscar(Clientes cli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            rs = ps.executeQuery();
            
            if (rs.next()){
                cli.setId(Integer.parseInt(rs.getString("id")));
                cli.setDescripcion(rs.getString("descripcion"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setRuc(rs.getString("ruc"));
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
