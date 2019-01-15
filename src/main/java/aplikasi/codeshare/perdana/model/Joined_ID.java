package main.java.aplikasi.codeshare.perdana.model;

import java.util.Objects;

public class Joined_ID {
    Integer id_joined_id;
    Produk produk;
    Jenis jenis;
    Kondisi kondisi;


    public Joined_ID(Integer id_joined_id, Produk produk, Jenis jenis, Kondisi kondisi) {
        this.id_joined_id = id_joined_id;
        this.produk = produk;
        this.jenis = jenis;
        this.kondisi = kondisi;
    }

    public Joined_ID() {
    }

    public Integer getId_joined_id() {
        return id_joined_id;
    }

    public void setId_joined_id(Integer id_joined_id) {
        this.id_joined_id = id_joined_id;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    public void setKondisi(Kondisi kondisi) {
        this.kondisi = kondisi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joined_ID joined_id = (Joined_ID) o;
        return Objects.equals(id_joined_id, joined_id.id_joined_id) &&
                Objects.equals(produk, joined_id.produk) &&
                Objects.equals(jenis, joined_id.jenis) &&
                Objects.equals(kondisi, joined_id.kondisi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_joined_id, produk, jenis, kondisi);
    }

    @Override
    public String toString() {
        return "Joined_ID{" +
                "id_joined_id=" + id_joined_id +
                ", produk=" + produk +
                ", jenis=" + jenis +
                ", kondisi=" + kondisi +
                '}';
    }
}
