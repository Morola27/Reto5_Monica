/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Vistas.*;
import Modelo.*;

public class Main {

   
    public static void main(String[] args) {
        //1. Crear Instancia de vista Login
        
            Login login = new Login();
        //2. Este metodo hace visble la ventana     
            login.setVisible(true);
            
        //3. Crar inatancia de la clase conexion 
        Conexiones conexiones = new Conexiones ();
        conexiones.getConnection();
        
        
    }
    
}