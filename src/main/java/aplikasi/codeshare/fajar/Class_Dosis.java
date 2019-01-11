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
public class Class_Dosis {
    private int id_dosis;
    private String dosis_harian;
    private String Dosis_obat;

    public Class_Dosis() {
    }

    public Class_Dosis(int id_dosis, String dosis_harian, String Dosis_obat) {
        this.id_dosis = id_dosis;
        this.dosis_harian = dosis_harian;
        this.Dosis_obat = Dosis_obat;
    }

    public int getId_dosis() {
        return id_dosis;
    }

    public void setId_dosis(int id_dosis) {
        this.id_dosis = id_dosis;
    }

    public String getDosis_harian() {
        return dosis_harian;
    }

    public void setDosis_harian(String dosis_harian) {
        this.dosis_harian = dosis_harian;
    }

    public String getDosis_obat() {
        return Dosis_obat;
    }

    public void setDosis_obat(String Dosis_obat) {
        this.Dosis_obat = Dosis_obat;
    }
    
}
