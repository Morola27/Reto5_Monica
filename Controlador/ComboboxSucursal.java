/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexiones;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ComboboxSucursal {
    Connection connection;
    Conexiones conexiones = new Conexiones ();
    Statement st;
    ResultSet rs;
    
    public ComboboxSucursal(){
         
    }
    
    public ArrayList getListaSucursales() {
        System.out.println("Función getListaSucursales()");
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        try {
            connection = conexiones.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM sucursal;");
            while(rs.next()){
                sucursal = new Sucursal ();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucursal);
            }
            
                
        } catch (SQLException e) {
            System.out.println("Error");
        }
    return mListaSucursales;
    }
    
}
