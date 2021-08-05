/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_referencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author lsfer
 */
public class Altas {
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    /* Secccion de altas para entidad de Categoria */
    
    public void alta(String nombre, String descripcion) {
        Conexion connect = new Conexion();
        Connection con = connect.getConexion();
        try {
            ps = con.prepareStatement("INSERT INTO categoria (nombre, descripcion) VALUES (?,?)");
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Alta de categoría exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de alta la categoría");
            }
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(e);
        }
    }
    
    /* Seccion de altas para entidad de textos */
    private String fecha_edicion;
    
    public void alta(String isbn, String autor, String titulo, String no_paginas, String dia, String mes, String año, 
            String editorial, int id_categoria, String fragmento_texto) {
        
        fecha_edicion = dia + "-" + mes + "-" + año;
        
        
        Conexion connect = new Conexion();
        try {
            Connection con = connect.getConexion();
            ps = con.prepareStatement("INSERT INTO texto (isbn, autor, titulo, no_paginas, fecha_edicion, editorial"
                    + ", id_categoria, fragmento_texto) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, isbn);
            ps.setString(2, autor);
            ps.setString(3, titulo);
            ps.setString(4, no_paginas);
            ps.setString(5, fecha_edicion);
            ps.setString(6, editorial);
            ps.setInt(7, id_categoria); //CHECAR ESTA PARTE SI NO CAUSA CONFLICTO, SINO TRATAR DE HACER ID_CATEGORIA STRING EN SQL
            ps.setString(8, fragmento_texto);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Alta de texto exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de alta el texto");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(e);
        }
    }
    
    /* Seccion de altas para entidad de referencias */
    public void alta(int id_texto_actual, int id_texto_destino) {
        Conexion connect = new Conexion();
        try {
            Connection con = connect.getConexion();
            ps = con.prepareStatement("INSERT INTO referencia (id_texto_actual, id_texto_destino) VALUES (?,?)");
            ps.setInt(1, id_texto_actual);
            ps.setInt(2, id_texto_destino);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Alta de referencia exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de alta la referencia");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(e);
        }
    }
}
