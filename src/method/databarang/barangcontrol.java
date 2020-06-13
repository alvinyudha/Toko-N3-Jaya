/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.databarang;

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
public class barangcontrol {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public barangcontrol() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:myssql://localhost:3306/sistem_informasi_toko", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal, Terjadi kesalahan pada : \n" + e);
        }
    }

    public List tampilbarang(String Nonota) {
        List logPenjualan = new ArrayList();
        sql = "select kode_barang,nama_barang,harga_jual,jumlah_beli,total_bayar from tb_penjualan where no_nota='" + Nonota + "'";
        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                databarang dp = new databarang();
                dp.setKodeBarang(rs.getString("kode_barang"));
                dp.setNamaBarang(rs.getString("nama_barang"));
                dp.setHargaJual(rs.getInt("harga_jual"));
                dp.setJumlahBeli(rs.getInt("jumlah_beli"));
                dp.setTotalBayar(rs.getInt("total_bayar"));

                logPenjualan.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan tampil, pada : \n" + e);
        }
        return logPenjualan;
    }

    public List caribarang(String cari) {
        List logBarang = new ArrayList();
        sql = "select no_nota,kode_barang,nama_barang,harga_jual,jumlah_beli,total from tb_penjualan where no_nota like '%" + cari + "%'or nama_barang like '%" + cari + "%'";
        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                databarang DO = new databarang();
                DO.setKodeBarang(rs.getString("kode_barang"));
                DO.setNamaBarang(rs.getString("nama_barang"));
                DO.setHargaJual(rs.getInt("harga_jual"));
                DO.setJumlahBeli(rs.getInt("jumlah_beli"));
                DO.setTotalBayar(rs.getInt("total_bayar"));

                logBarang.add(DO);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan tampil, pada : \n" + e);
        }
        return logBarang;
    }

    public List cekbarang(String Nonota, String KodeBarang) {
        List logDetailBeli = new ArrayList();
        sql = "select no_nota,kode_barang,nama_barang,harga_jual,jumlah_beli,total from tb_penjualan where no_nota='" + Nonota + "'and kode_barang'" + KodeBarang + "'";
        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                databarang dp = new databarang();
                dp.setKodeBarang(rs.getString("kode_barang"));
                dp.setNamaBarang(rs.getString("nama_barang"));
                dp.setHargaJual(rs.getInt("harga_jual"));
                dp.setJumlahBeli(rs.getInt("jumlah_beli"));
                dp.setTotalBayar(rs.getInt("total_bayar"));

                logDetailBeli.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan tampil, pada : \n" + e);
        }
        return logDetailBeli;
    }

    public int tambahpenjualan(databarang e) {
        sql = "insert into tb_penjualan where values('" + e.getnota() + "','" + e.getKodeBarang()
                + "','" + e.getNamaBarang() + "','" + e.getHargaJual() + "','" + e.getJumlahBeli() + "','" + e.getTotalBayar() + "','";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (SQLException a) {
            Logger.getLogger(barangcontrol.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil;
    }

    public int deletepenjualan(String Nonota, String KodeBarang) {
        sql = "delete from tb_penjualan where no_nota='" + Nonota + "'and kode_barang='" + KodeBarang + "'";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (SQLException a) {
            Logger.getLogger(barangcontrol.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil;
    }
}
