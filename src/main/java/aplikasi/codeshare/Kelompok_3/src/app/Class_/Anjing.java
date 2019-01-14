/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.Kelompok_3.src.app.Class_;

/**
 *
 * @author Centry
 */

public class Anjing {
    private int id_anjing;
    private String nama;
    private String jenis;
    private String kebiasaan;

    public Anjing(int id_anjing, String nama, String jenis, String kebiasaan) {
        this.id_anjing = id_anjing;
        this.nama = nama;
        this.jenis= jenis;
        this.kebiasaan= kebiasaan;
    }
    public Anjing(){

    }

    public int getId_anjing() {
        return id_anjing;
    }
    public void setId_anjing(int id_anjing) {
        this.id_anjing = id_anjing;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getKebiasaan() {
        return kebiasaan;
    }
    public void setKebiasaan(String kebiasaan) {
        this.kebiasaan = kebiasaan;
    }

}