package proyectomysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author junn3r
 */
public class accesoBd {

    private String host;
    private String basedatos;
    private String usuario;
    private String password;
    

    public accesoBd() {

    }

    public static Connection getConexion() {
        Connection cn=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/dsitribuidospractica1", "junner", "123");
        } catch (Exception e) {
            System.out.println("No nos conectamos ): " + e.toString());
        }
        return cn;
    }

    public void actualizaBD(String sql) {
        
        try {
            Statement stm = getConexion().createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error de transaccion.." + e.toString());
        }
    }

    public ResultSet consultaBD(String sql) throws Exception {
        ResultSet cursor;
        Statement stm = getConexion().createStatement();
        cursor = stm.executeQuery(sql);
        return cursor;
    }
    
    public void cerrarBd() {
        
        try {
            getConexion().close();
            System.out.println("Conexion apagada.");
        } catch (Exception e) {
                        System.out.println("Error al cerrar base de datos.");
        }
    }

}
