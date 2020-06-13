/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.databarang;

/**
 *
 * @author Alvin Y
 */
public class databarang {

    private String no_nota, kode_barang, nama_barang;
    int harga_jual, jumlah_beli, total_bayar;

    public String getnota() {
        return no_nota;
    }

    public void setNonota(String no_nota) {
        this.no_nota = no_nota;
    }

    public String getKodeBarang() {
        return kode_barang;
    }

    public void setKodeBarang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNamaBarang() {
        return nama_barang;
    }

    public void setNamaBarang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHargaJual() {
        return harga_jual;
    }

    public void setHargaJual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getJumlahBeli() {
        return jumlah_beli;
    }

    public void setJumlahBeli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    public int getTotalBayar() {
        return total_bayar;
    }

    public void setTotalBayar(int total) {
        this.total_bayar = total_bayar;
    }
}
