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
public class Class_Obat {
    private int id;
    private String nama_obat;

    public Class_Obat() {
    }

    public Class_Obat(int id, String nama_obat) {
        this.id = id;
        this.nama_obat = nama_obat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
    
}
