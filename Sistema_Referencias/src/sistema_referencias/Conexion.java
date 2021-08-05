
package sistema_referencias;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    
    private Connection conectar = null;
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ref_bd","root","");
            //JOptionPane.showInputDialog(null, "Conexion Establecida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showInputDialog("Error al conectarse :" + e.toString());
        }
        
        return conectar;
    }
}
