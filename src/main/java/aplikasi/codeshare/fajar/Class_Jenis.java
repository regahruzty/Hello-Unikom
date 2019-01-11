/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fajar;

/**
 *
 * @author Centry
 */
public class Class_Jenis{
    private int id;
    private String jenis;
    private String kategori;
    private String keterangan;

    public Class_Jenis() {
    }

    public Class_Jenis(int id, String jenis, String kategori, String keterangan) {
        this.id = id;
        this.jenis = jenis;
        this.kategori = kategori;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
