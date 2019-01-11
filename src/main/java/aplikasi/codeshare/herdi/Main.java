package main.java.aplikasi.codeshare.herdi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
class Burung {
    private String nama;
    private String usia;
    private String warna;
    private String paruh;
    private Date tanggalLahir;
    //ini no args constructor
    public Burung() {
    }
    //ini args constructor
    public Burung(String nama, String usia, String warna, String paruh, Date tanggalLahir) {
        this.nama = nama;
        this.usia = usia;
        this.warna = warna;
        this.paruh = paruh;
        this.tanggalLahir = tanggalLahir;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getUsia() {
        return usia;
    }
    public void setUsia(String usia) {
        this.usia = usia;
    }
    public String getWarna() {
        return warna;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }
    public String getParuh() {
        return paruh;
    }
    public void setParuh(String paruh) {
        this.paruh = paruh;
    }
    public Date getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}
class Merpati extends Burung {
    public Merpati(String nama, String usia, String warna, String paruh, Date tanggalLahir) {
        super(nama, usia, warna, paruh, tanggalLahir);
    }
    public Merpati() {
    }
    public void terbang(String pakai){
        System.out.println("Value dari merpati");
        System.out.println("Merpati terbang menggunakan "+pakai);
    }
    public void jarakTerbang(int jarak){
        System.out.println("Jarak terbang merpati sekitar "+jarak);
    }
}
class Elang extends Burung{
    public Elang(String nama, String usia, String warna, String paruh, Date tanggalLahir) {
        super(nama, usia, warna, paruh, tanggalLahir);
    }
    public void terbang(String pakai){
        System.out.println("Value dari Elang");
        System.out.println("Elang terbang menggunakan "+pakai);
    }
    public void jarakTerbang(int jarak){
        System.out.println("Jarak terbang elang sekitar "+jarak);
    }
}
public class Main {
    //JDBC DRIVER
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_burung";
    //DB CREDENTIAL
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt =conn.createStatement();
            String sql = "Select * from merpati";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Merpati merpati = new Merpati();
                merpati.setNama(rs.getString("nama_merpati"));
                merpati.setWarna(rs.getString("warna_merpati"));
                merpati.setParuh(rs.getString("paruh_merpati"));
                merpati.setTanggalLahir(rs.getDate("tgl_merpati"));
                //display
                System.out.println("Merpati bernama : "+merpati.getNama());
                System.out.println("Merpati berwarna : "+merpati.getWarna());
                System.out.println("Merpati memiliki ciri paruh : "+merpati.getParuh());
                System.out.println("Merpati lahir tanggal : "+merpati.getTanggalLahir());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //class merpati
//        Merpati merpati = new Merpati("Merpati ODC","5 tahun","Hitam kecoklatan","Runcing, Kecil", new Date());
//
//        System.out.println("Burung ini bernama "+merpati.getNama());
//        System.out.println("Burung ini berusia "+merpati.getUsia());
//        System.out.println("Burung ini berwarna "+merpati.getWarna());
//        System.out.println("Burung ini mempunyai paruh yang "+merpati.getParuh());
//        System.out.println("Burung ini lahir tanggal "+merpati.getTanggalLahir());
//
//        merpati.terbang("Sayap dibantu ekor");
//        merpati.jarakTerbang(20);
//        System.out.print(" Km");
//
//        System.out.println("");
//
//        //class Elang
//        Elang elang = new Elang("Elang Jawa", "10 tahun", "Coklat", "Kuat, Tajam", new Date());
//        System.out.println("Burung ini bernama "+elang.getNama());
//        System.out.println("Burung ini berusia "+elang.getUsia());
//        System.out.println("Burung ini berwarna "+elang.getWarna());
//        System.out.println("Burung ini mempunyai paruh yang "+elang.getParuh());
//        System.out.println("Burung ini lahir tanggal "+elang.getTanggalLahir());
//
//        elang.terbang("Sayap");
//        elang.jarakTerbang(300);
//        System.out.print(" Km");
    }
}
