package main.java.aplikasi.codeshare.azizan.Services;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.Model.Smartphone;
import main.java.aplikasi.codeshare.azizan.Model.Anjing;
import main.java.aplikasi.codeshare.azizan.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.Model.Obat;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NarasiService {
    public static void Menarasikan() throws SQLException, ClassNotFoundException {
        Class.forName(KoneksiDB.JDBC_DRIVER_MYSQL);
        Connection conn = DriverManager.getConnection(KoneksiDB.DB_URL, KoneksiDB.USER, KoneksiDB.PASS);
        Statement stmt = conn.createStatement();
        KucingServiceUtils.initProcess(conn, stmt);
    }

    static class KucingServiceUtils {
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
                    tentara.setNama(rs.getString("nama tentara"));
                    tentara.setMatra(rs.getString("matra tentara"));
                    tentara.setPangkat(rs.getString("pangkat tentara"));
                    anjing.setNama((rs.getString("nama anjing")));
                    anjing.setJenis(rs.getString("jenis anjing"));
                    anjing.setKebiasaan(rs.getString("kebiasaan anjing"));
                    obat.setNama_obat(rs.getString("nama obat"));
                    obat.setDosis_obat(rs.getString("dosis obat"));
                    obat.setKeterangan_obat(rs.getString("keterangan obat"));
                    smartphone.setMerk(rs.getString("merk hp"));
                    smartphone.setType(rs.getString("tipe hp"));
                    smartphone.setRam(rs.getInt("ram hp"));

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
                String sqlObat;
                String sqlAnjing;
                String sqlSmartphone;

                sqlNarasi = "SELECT tentara.nama, tentara.matra, tentara.pangkat, anjing.nama, anjing.jenis, anjing.kebiasaan, obat.nama_obat, obat.dosis, obat.Keterangan, smartphone.merk, smartphone.type, smartphone.ram\n" +
                        "FROM narasi, anjing, tentara, obat, smartphone\n" +
                        "WHERE narasi.id_anjing = anjing.id_anjing AND narasi.id_tentara = tentara.id_tentara AND narasi.id_obat = obat.id_obat AND narasi.smartphone_id = smartphone.smartphone_id;";


                List<String>  narasiList = coreProcess(stmt, sqlNarasi);

                System.out.println("Selamat");
            } catch (
                    Exception e) {
                System.out.println("Masuk Jurang");
                e.printStackTrace();
            }
        }

    }
}
