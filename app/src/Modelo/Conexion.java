package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    Connection con = null;
    // Creamos las variables de conexión
    String bd = "GESTION_VENTAS";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String password = "";
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
    }
}
