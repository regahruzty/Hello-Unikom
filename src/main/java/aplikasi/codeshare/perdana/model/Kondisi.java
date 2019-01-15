package main.java.aplikasi.codeshare.perdana.model;

import java.util.Objects;

public class Kondisi {
    Integer id_kondisi;
    String body;
    String mesin;
    String create_date;


    public Kondisi(Integer id_kondisi, String body, String mesin, String create_date) {
        this.id_kondisi = id_kondisi;
        this.body = body;
        this.mesin = mesin;
        this.create_date = create_date;
    }

    public Kondisi() {
    }

    public Integer getId_kondisi() {
        return id_kondisi;
    }

    public void setId_kondisi(Integer id_kondisi) {
        this.id_kondisi = id_kondisi;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMesin() {
        return mesin;
    }

    public void setMesin(String mesin) {
        this.mesin = mesin;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kondisi kondisi = (Kondisi) o;
        return Objects.equals(id_kondisi, kondisi.id_kondisi) &&
                Objects.equals(body, kondisi.body) &&
                Objects.equals(mesin, kondisi.mesin) &&
                Objects.equals(create_date, kondisi.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_kondisi, body, mesin, create_date);
    }

    @Override
    public String toString() {
        return "Kondisi{" +
                "id_kondisi=" + id_kondisi +
                ", body='" + body + '\'' +
                ", mesin='" + mesin + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
