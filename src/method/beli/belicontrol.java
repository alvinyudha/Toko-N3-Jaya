/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.beli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvin Y
 */
public class belicontrol {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public belicontrol() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:myssql://localhost:3306/sistem_informasi_toko", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal, Terjadi kesalahan pada : \n" + e);
        }
    }

    public List tampil() {
        List logBeli = new ArrayList();
        sql = "select no_nota, tanggal_beli, nama_pembeli, total, tunai, kembalian, from tb_beli order by id_beli asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                databeli db = new databeli();
                db.setNonota(rs.getString("no_nota"));
                db.setTanggal(rs.getString("tanggal_beli"));
                db.setNamaPembeli(rs.getString("nama_pembeli"));
                db.setTotal(rs.getInt("total"));
                db.setTunai(rs.getInt("tunai"));
                db.setKembalian(rs.getInt("kembalian"));
                logBeli.add(db);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan tampil, pada : \n" + e);
        }
        return logBeli;
    }
}
