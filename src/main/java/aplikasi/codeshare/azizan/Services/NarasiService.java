package main.java.aplikasi.codeshare.azizan.Services;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.Model.Smartphone;
import main.java.aplikasi.codeshare.azizan.Model.Anjing;
import main.java.aplikasi.codeshare.azizan.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.Model.Obat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NarasiService {
    public static void Menarasikan() throws SQLException, ClassNotFoundException {
        Class.forName(KoneksiDB.JDBC_DRIVER_MYSQL);
        Connection conn = DriverManager.getConnection(KoneksiDB.DB_URL, KoneksiDB.USER, KoneksiDB.PASS);
        Statement stmt = conn.createStatement();
        NarasiServiceUtils.initProcess(conn, stmt);
    }

    static class NarasiServiceUtils {
        public static List<String> coreProcess(Statement stmt, String sql) {
            try {
                ResultSet rs = stmt.executeQuery(sql);

                List<String> narasiList = new ArrayList<>();

                System.out.println("ini hasil inisialisasi awal " + narasiList);

                System.out.println("ini size awal " + narasiList.size());
                Tentara tentara = new Tentara();
                Anjing anjing = new Anjing();
                Obat obat = new Obat();
                Smartphone smartphone = new Smartphone();
                String temp = "";

                while (rs.next()) {
                    tentara.setNama(rs.getString("nama_tentara"));
                    tentara.setMatra(rs.getString("matra"));
                    tentara.setPangkat(rs.getString("pangkat"));
                    anjing.setNama((rs.getString("nama_anjing")));
                    anjing.setJenis(rs.getString("jenis_anjing"));
                    anjing.setKebiasaan(rs.getString("kebiasaan_anjing"));
                    obat.setNama_obat(rs.getString("nama_obat"));
                    obat.setDosis_obat(rs.getString("dosis"));
                    obat.setKeterangan_obat(rs.getString("keterangan"));
                    smartphone.setMerk(rs.getString("merk"));
                    smartphone.setType(rs.getString("tipe"));
                    smartphone.setRam(rs.getInt("ram"));

                    temp = temp + "tentara beranama " + tentara.getNama();
                    temp = temp + "tentara beranama " + tentara.getNama();

                    narasiList.add(temp);
                }
                System.out.println("Selamat Core");
                return narasiList;

            } catch (Exception e) {
                throw new RuntimeException("Masuk Jurang Core");
            }

        }

        public static void initProcess(Connection conn, Statement stmt) {
            try {
                String sqlNarasi;

                sqlNarasi = "SELECT t.nama AS nama_tentara, t.pangkat AS pangkat, t.matra AS Matra,\n" +
                        " o.nama_obat AS nama_obat, o.dosis AS dosis, o.Keterangan AS keterangan,\n" +
                        " s.merk AS merk, s.type AS tipe, s.ram AS ram, s.camera AS camera,\n" +
                        " a.nama AS nama_anjing, a.jenis AS jenis_anjing, a.kebiasaan AS kebiasaan_anjing \n" +
                        "FROM narasi n JOIN obat o ON n.id_obat = o.id_obat\n" +
                        "        JOIN smartphone s ON n.smartphone_id = s.smartphone_id\n" +
                        "        JOIN tentara t ON n.id_tentara = t.id_tentara\n" +
                        "        JOIN anjing a ON n.id_anjing = a.id_anjing;";


                List<String> narasiList = coreProcess(stmt, sqlNarasi);

                System.out.println("Selamat");
            } catch (
                    Exception e) {
                System.out.println("Masuk Jurang");
                e.printStackTrace();
            }
        }

    }
}
