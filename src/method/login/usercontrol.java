/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvin Y
 */
public class usercontrol {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public usercontrol() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistem_informasi_toko", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal, Terjadi kesalahan pada : \n" + e);
        }
    }

    public List cariLogin(String username, String password) {
        List logLogin = new ArrayList();
        int result;
        sql = "select username, password, hak_akses from user where username='" + username + "'and password='" + password + "'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                datauser ep = new datauser();
                ep.setusername(rs.getString("username"));
                ep.setpassword(rs.getString("password"));
                ep.sethak_akses(rs.getString("hak_akses"));
                logLogin.add(ep);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Login, Pada:n" + e);
        }
        return logLogin;
    }

    public List carid(int id_user) {
        List logLogin = new ArrayList();
        int resulr;
        sql = "select id_user from user where id_user='" + id_user + "'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                datauser ep = new datauser();
                ep.setid_user(rs.getInt("id_user"));
                logLogin.add(ep);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pencarian id, pada" + e);
        }
        return logLogin;
    }

    public int tambah(datauser e) {
        sql = "insert into user valaue('" + e.getid_user() + "','" + e.getusername() + "','" + e.getpassword() + "','" + e.gethak_akses() + "')";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            Logger.getLogger(usercontrol.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil;
    }

    public int deleteuser(datauser e) {
        sql = "delete user where id_user='" + e.getid_user() + "'";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            Logger.getLogger(usercontrol.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil = 0;
    }

    public List tampil() {
        List logBarang = new ArrayList();
        sql = "select id_user, username, password, hak_akses from user order by id_user asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                datauser du = new datauser();
                du.setid_user(rs.getInt("id_user"));
                du.setusername(rs.getString("username"));
                du.setpassword(rs.getString("password"));
                du.sethak_akses(rs.getString("hak_akses"));
                logBarang.add(du);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan tampil, pada:" + e);
        }
        return logBarang;
    }
}
