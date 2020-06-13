/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.beli;

/**
 *
 * @author Alvin Y
 */
public class databeli {

    private String no_nota, tanggal_beli, nama_pembeli;

    public String getNonota() {
        return no_nota;
    }

    public void setNonota(String no_nota) {
        this.no_nota = no_nota;

    }

    public String getTanggal() {
        return tanggal_beli;
    }

    public void setTanggal(String tanggal_beli) {
        this.tanggal_beli = tanggal_beli;
    }

    public String getNamaPembeli() { 
        return nama_pembeli;
    }

    public void setNamaPembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    int total, tunai, kembalian;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTTunai() {
        return tunai;
    }

    public void setTunai(int tunai) {
        this.tunai = tunai;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }
}
