
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexiones {
  
    Connection connection; 
    String driver = "com.mysql.cj.jdbc.Driver" ; 
    String cadenaConexion = "jdbc:mysql://localhost:3306/1reto_g53_db";
    String usuario = "root";
    String contrasena = ""; 
            
    public Conexiones() {
     try{
        Class.forName(driver);
        connection =DriverManager.getConnection(cadenaConexion, usuario, contrasena);
        if(connection!=null){
        System.out.println("Conexión Exitosa con la base de datos");  
        
    }
    }  catch(ClassNotFoundException | SQLException e ){
        System.out.println("No se pudo establecer conexion con la base de datos ");
    }
    }
    
    public Connection getConnection (){
        return connection;
    }
}

    