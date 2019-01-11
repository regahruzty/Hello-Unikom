package main.java.aplikasi.service;

import main.java.aplikasi.config.KoneksiDB;
import main.java.aplikasi.model.Kucing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author regahruzty
 */
public class KucingService{

    public void selectPemilikKucing() throws SQLException, ClassNotFoundException {
        Class.forName(KoneksiDB.JDBC_DRIVER_MYSQL);
        Connection conn = DriverManager.getConnection(KoneksiDB.DB_URL,KoneksiDB.USER,KoneksiDB.PASS);
        Statement stmt = conn.createStatement();
        KucingServiceUtils.initProcess(conn, stmt);
    }
}

class KucingServiceUtils{
    public static List<Kucing> coreProcess(Statement stmt, String sql) {
        try {
            ResultSet rs = stmt.executeQuery(sql);

            List<Kucing> kucingList = new ArrayList<>();

            System.out.println("ini hasil inisialisasi awal " + kucingList);

            System.out.println("ini size awal " + kucingList.size());

            while (rs.next()) {
//          ----------------------------------------------------------------------------------
                Kucing kucing = new Kucing();
//              --------------------------------------------------------------------------
                kucing.setNama(rs.getString("nama"));
                kucing.setJenis(rs.getString("jenis"));
                if (rs.getByte("is_liar") == 0) {
                    kucing.setLiar(false);
                } else {
                    kucing.setLiar(true);
                }
                kucing.setTanggalLahir(rs.getDate("tanggal_lahir"));
//              --------------------------------------------------------------------------
                kucingList.add(kucing);
            }
            System.out.println("Selamat Core");
            return kucingList;
        } catch (Exception e) {
            throw new RuntimeException("Masuk Jurang Core");
        }

    }

    public static void initProcess(Connection conn, Statement stmt) {
        try {
            String sqlJinak;
            String sqlLiar;
            String sqlJinakLiar;

            sqlJinak = "select * from pemilik_kucing where is_liar = 0;";
            sqlLiar = "select * from pemilik_kucing where is_liar = 1;";
            sqlJinakLiar = "select * from pemilik_kucing;";

            List<Kucing> kucingJinakList = coreProcess(stmt, sqlJinak);
            List<Kucing> kucingLiarList = coreProcess(stmt, sqlLiar);
            List<Kucing> allKucingList = coreProcess(stmt, sqlJinakLiar);

            System.out.println("ini size list kucing jinak setelah looping " + kucingJinakList.size());

            System.out.println("ini size list kucing liar setelah looping " + kucingLiarList.size());

            System.out.println("ini size all kucing list setelah looping " + allKucingList.size());

            for (Kucing kucing : kucingLiarList) {
                System.out.print("Ini List Pemilik Kucing Liar : ");
                System.out.print("Nama: " + kucing.getNama());
                System.out.print(", Jenis: " + kucing.getJenis());
                System.out.print(", Liar: " + (kucing.getLiar() ? "Liar" : "Jinak"));
                System.out.println(", Tanggal Lahir: " + kucing.getTanggalLahir());
            }

            for (Kucing kucing : kucingJinakList) {
                System.out.print("Ini List Pemilik Kucing Jinak : ");
                System.out.print("Nama: " + kucing.getNama());
                System.out.print(", Jenis: " + kucing.getJenis());
                System.out.print(", Liar: " + (kucing.getLiar() ? "Liar" : "Jinak"));
                System.out.println(", Tanggal Lahir: " + kucing.getTanggalLahir());
            }

            for (Kucing kucing : allKucingList) {
                System.out.print("Ini List Pemilik All Kucing : ");
                System.out.print("Nama: " + kucing.getNama());
                System.out.print(", Jenis: " + kucing.getJenis());
                System.out.print(", Liar: " + (kucing.getLiar() ? "Liar" : "Jinak"));
                System.out.println(", Tanggal Lahir: " + kucing.getTanggalLahir());
            }

            System.out.println("Selamat");
        } catch (
                Exception e) {
            System.out.println("Masuk Jurang");
            e.printStackTrace();
        }
    }
}