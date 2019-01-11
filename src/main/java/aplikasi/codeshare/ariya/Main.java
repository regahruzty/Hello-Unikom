package main.java.aplikasi.codeshare.ariya;//STEP 1. Import required packages
import java.sql.*;
<<<<<<< HEAD

=======
>>>>>>> f84438b59f0d4b7841b51ed64dddd2851499cadf
import main.java.aplikasi.codeshare.ariya.model.Motor;
import main.java.aplikasi.codeshare.ariya.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.model.Transaksi;


public class Main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/boothcamp";

    //  Database credentials
    static final String USER = "root";
<<<<<<< HEAD

    static final String PASS = "root";


=======
    static final String PASS = "root";
>>>>>>> f84438b59f0d4b7841b51ed64dddd2851499cadf

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select id_transaksi, "
                    + "merk_motor, "
                    + "nama_motor, "
                    + "harga, "
                    + "nama_pembeli, "
                    + "jumlah_pembelian, "
                    + "tanggal_pembelian "
                    + "from transaksi "
                    + "join motor on transaksi.id_motor = motor.id_motor "
                    + "join pembeli on transaksi.id_pembeli = pembeli.id_pembeli";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                Transaksi transaksi = new Transaksi();
                Motor motor = new Motor();
                Pembeli pembeli = new Pembeli();
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                motor.setMerk_motor(rs.getString("merk_motor"));
                motor.setNama_motor(rs.getString("nama_motor"));
                motor.setHarga(rs.getInt("harga"));
                pembeli.setNama_pembeli(rs.getString("nama_pembeli"));
                transaksi.setJumlah_pembelian(rs.getInt("jumlah_pembelian"));
                transaksi.setTanggal_pembelian(rs.getDate("tanggal_pembelian"));
                //Display values

                System.out.println("======================================");
                System.out.println("id_transaksi: " + transaksi.getId_transaksi());
                System.out.println("merk_motor: " + motor.getMerk_motor());
                System.out.println("nama_motor: " + motor.getNama_motor());
                System.out.println("harga: " + motor.getHarga());
                System.out.println("nama_pembeli: " + pembeli.getNama_pembeli());
                System.out.println("jumlah_pembelian: " + transaksi.getJumlah_pembelian());
				System.out.println("tanggal_pembelian: " + transaksi.getTanggal_pembelian());
                System.out.println("======================================");

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

}
