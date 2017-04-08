/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Posttest6;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Avalon
 */
public class koneksi {
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_visual","root","");
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal"+e.getMessage());
        }
        return con;
    }

    koneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean update(String id, String judul, String penulis, String harga) throws SQLException {
        String sql="update buku set judul='"+judul+"', penulis='"+penulis+"',harga='"+harga+"' WHERE ID='"+id+"'";
        
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_visual","root","");
            Statement s=con.prepareStatement(sql);
            s.execute(sql);
            return true;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Boolean delete(String id) {
        String sql="DELETE FROM buku WHERE id='"+id+"'";
        
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_visual","root","");
            Statement s=con.prepareStatement(sql);
            s.execute(sql);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
