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
public class Bajas {
    private PreparedStatement ps;
    private ResultSet rs;
    
    /* Secccion de baja para entidad de Categoria */
    
    public void bajaCategoria(int id_categoria) {
        Conexion connect = new Conexion();
        try {
            Connection con = connect.getConexion();
            ps = con.prepareStatement("DELETE FROM categoria WHERE id_categoria=?");
            ps.setInt(1, id_categoria);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Baja de categoría exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de baja la categoría");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(e);
        }
    }
    
    /* Seccion de baja para entidad de textos */
    public void bajaTexto(int id_texto) {
        Conexion connect = new Conexion();
        try {
            Connection con = connect.getConexion();
            ps = con.prepareStatement("DELETE FROM texto WHERE id_texto=?");
            ps.setInt(1, id_texto);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Baja de texto exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de baja el texto");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e);
        }
    }
    
    /* Seccion de baja para entidad de referencias */
    public void bajaReferencia(int id_referencia) {
        Conexion connect = new Conexion();
        try {
            Connection con = connect.getConexion();
            ps = con.prepareStatement("DELETE FROM referencia WHERE id_referencia=?");
            ps.setInt(1, id_referencia);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showInputDialog("Baja de referencia exitosa");
            } else {
                JOptionPane.showInputDialog("Ocurrio un error al dar de baja la referencia");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showInputDialog(e);
        }
    }
}
