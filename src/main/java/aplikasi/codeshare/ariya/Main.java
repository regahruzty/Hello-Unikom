package main.java.aplikasi.codeshare.ariya;//STEP 1. Import required packages
import java.sql.*;

public class Main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/boothcamp";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

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


public static class Transaksi {
    int id_transaksi, id_pembeli, id_motor, jumlah_pembelian;
    Date tanggal_pembelian;

    public Transaksi(){
        
    }
    
    public Transaksi(int id_transaksi, int id_pembeli, int id_motor, int jumlah_pembelian, Date tanggal_pembelian) {
        this.id_transaksi = id_transaksi;
        this.id_pembeli = id_pembeli;
        this.id_motor = id_motor;
        this.jumlah_pembelian = jumlah_pembelian;
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getJumlah_pembelian() {
        return jumlah_pembelian;
    }

    public void setJumlah_pembelian(int jumlah_pembelian) {
        this.jumlah_pembelian = jumlah_pembelian;
    }

    public Date getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(Date tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }
    
     public void outputTransaksi(){
        System.out.println("Nama Pembeli : "+getId_pembeli());
        System.out.println("Nama Motor : "+getId_motor());
        System.out.println("Tanggal Pembelian : "+getTanggal_pembelian());
        System.out.println("Jumlah Pembelian : "+getJumlah_pembelian());
    }
      
}

public static class Pembeli {
    
    String nama_pembeli, pekerjaan, alamat;
    int id_pembeli;

    public Pembeli(){
        
    }
    
    public Pembeli(String nama_pembeli, String pekerjaan, String alamat, int id_pembeli) {
        this.nama_pembeli = nama_pembeli;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
        this.id_pembeli = id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }
    
    public void outputPembeli(){
        System.out.println("Nama Pembeli : "+getNama_pembeli());
        System.out.println("Pekerjaan : "+getPekerjaan());
        System.out.println("Alamat : "+getAlamat());
        
    }
    
}


public static class Motor {
 
    String merk_motor, nama_motor;
    int id_motor, harga;

    public Motor(){
        
    }
    
    public Motor(String merk_motor, String nama_motor, int id_motor, int harga) {
        this.merk_motor = merk_motor;
        this.nama_motor = nama_motor;
        this.id_motor = id_motor;
        this.harga = harga;
    }
    
    

    public String getMerk_motor() {
        return merk_motor;
    }

    public void setMerk_motor(String merk_motor) {
        this.merk_motor = merk_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }    
    
    
    public void outputMotor(){
        System.out.println("Merk Motor : "+getMerk_motor());
        System.out.println("Nama Motor : "+getNama_motor());
        System.out.println("Harga Motor : "+getHarga());
        
    }
    
    
}


}//end FirstExample