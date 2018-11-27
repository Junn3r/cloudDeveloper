
package proyectomysql;

/**
 *
 * @author junn3r
 */
public class ProyectoMysql {

    public static void main(String[] args) {
       accesoBd bd1 = new accesoBd();
       bd1.getConexion();
       String cadena = "INSERT INTO usuarios VALUES (null,'Jean Carlos','Farfan', 'cdla Bellavista','09999999')";
       bd1.actualizaBD(cadena);
    }
    
}
