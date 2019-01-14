package main.java.aplikasi.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectPractice2 {

    public static void main(String[] args) {
        WargaNegaraKorea btsMemberSatu = new WargaNegaraKorea();
        btsMemberSatu.setIdWargaNegaraKorea(1);
        btsMemberSatu.setNama("JEON JUNG KOOK");

        WargaNegaraKorea btsMemberDua = new WargaNegaraKorea();
        btsMemberDua.setIdWargaNegaraKorea(2);
        btsMemberDua.setNama("JIN");

        List<WargaNegaraKorea> btsMember = new ArrayList<>();
        btsMember.add(btsMemberSatu);
        btsMember.add(btsMemberDua);

        KPOPGroup bts = new KPOPGroup();
        bts.setNamaGroup("BTS");
        bts.setAnggota(btsMember);

        int idx = 0;
        for (WargaNegaraKorea wargaNegaraKorea : bts.getAnggota()) {
            System.out.println("INI MEMBER "+bts.getNamaGroup()+" KE " + idx + " -> " + bts.getAnggota().get(idx).getNama());
            idx++;
        }

    }
}

class KPOPGroup{
    private String namaGroup;
    private List<WargaNegaraKorea> anggota;

    public KPOPGroup(String nama, List<WargaNegaraKorea> idWargaNegaraKorea) {
        this.namaGroup = nama;
        this.anggota = idWargaNegaraKorea;
    }

    public KPOPGroup() {
    }

    public String getNamaGroup() {
        return namaGroup;
    }

    public void setNamaGroup(String namaGroup) {
        this.namaGroup = namaGroup;
    }

    public List<WargaNegaraKorea> getAnggota() {
        return anggota;
    }

    public void setAnggota(List<WargaNegaraKorea> anggota) {
        this.anggota = anggota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KPOPGroup kpopGroup = (KPOPGroup) o;
        return Objects.equals(namaGroup, kpopGroup.namaGroup) &&
                Objects.equals(anggota, kpopGroup.anggota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namaGroup, anggota);
    }

    @Override
    public String toString() {
        return "KPOPGroup{" +
                "namaGroup='" + namaGroup + '\'' +
                ", anggota=" + anggota +
                '}';
    }
}

class WargaNegaraKorea{
    private Integer idWargaNegaraKorea;
    private String nama;

    public WargaNegaraKorea(Integer idWargaNegaraKorea, String nama) {
        this.idWargaNegaraKorea = idWargaNegaraKorea;
        this.nama = nama;
    }

    public WargaNegaraKorea() {
    }

    public Integer getIdWargaNegaraKorea() {
        return idWargaNegaraKorea;
    }

    public void setIdWargaNegaraKorea(Integer idWargaNegaraKorea) {
        this.idWargaNegaraKorea = idWargaNegaraKorea;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WargaNegaraKorea that = (WargaNegaraKorea) o;
        return Objects.equals(idWargaNegaraKorea, that.idWargaNegaraKorea) &&
                Objects.equals(nama, that.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWargaNegaraKorea, nama);
    }

    @Override
    public String toString() {
        return "WargaNegaraKorea{" +
                "anggota=" + idWargaNegaraKorea +
                ", nama='" + nama + '\'' +
                '}';
    }
}

