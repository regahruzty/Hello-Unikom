package main.java.aplikasi.codeshare.azizan.Services;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.Model.Anjing;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import main.java.aplikasi.codeshare.azizan.Model.Narasi;

public class NarasiService {
    public static void Menarasikan() throws SQLException, ClassNotFoundException {
        Class.forName(KoneksiDB.JDBC_DRIVER_MYSQL);
        Connection conn = DriverManager.getConnection(KoneksiDB.DB_URL, KoneksiDB.USER, KoneksiDB.PASS);
        Statement stmt = conn.createStatement();
        NarasiServiceUtils.initProcess(conn, stmt);
    }

    static class NarasiServiceUtils {
//        private static 

        public static List<Narasi> coreProcess(Statement stmt, String sql) {
            try {
                ResultSet rs = stmt.executeQuery(sql);

                List<Narasi> narasiList = new ArrayList<>();

                System.out.println("ini hasil inisialisasi awal " + narasiList);

                System.out.println("ini size awal " + narasiList.size());
                while (rs.next()) {
<<<<<<< HEAD
                    Narasi narasi = new Narasi();
                    narasi.anjing.setNama(rs.getString("nama"));
                    narasiList.add(narasi);
                }
                
                ;
                System.out.println("Selamat Core");
                
//                for (int i = 0; i < narasiList.size(); i++) {
//                    System.out.println(narasiList.get(i).);
//
//                }
=======
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
                    temp = temp + ", tentara beranama " + tentara.getNama();

                    narasiList.add(temp);
                    System.out.println(""+ temp);
                }

>>>>>>> f95cee7146ec2262ab3865f239cc6d3729386557
                return narasiList;

            } catch (Exception e) {
                throw new RuntimeException("Masuk Jurang Core");
            }

        }

        public static void initProcess(Connection conn, Statement stmt) {
            try {
                String sqlNarasi;

                sqlNarasi = "select * from anjing;";
                

                List<Narasi> narasiList = coreProcess(stmt, sqlNarasi);
//                narasi = new Narasi();
                  
                Iterator<Narasi> iter = narasiList.iterator();
                
                while(iter.hasNext()){
                    Narasi nar = iter.next();
                    System.out.println(nar.anjing.getNama());
                }
                System.out.println("Selamat");
            } catch (
                    Exception e) {
                System.out.println("Masuk Jurang");
                e.printStackTrace();
            }
        }

    }
}
