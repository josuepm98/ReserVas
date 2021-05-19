package reservas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	// Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "reservas";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    // public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=UTC";
    	
    // Nombre de usuario
    public String username = "taes";

    // Clave de usuario
    public String password = "password";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Error" + e);
        }

        return conn;
    }
}
