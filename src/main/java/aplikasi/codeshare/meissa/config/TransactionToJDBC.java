package main.java.aplikasi.codeshare.meissa.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionToJDBC {

    public static void main(String[] args) {
        Utils.migrate();
    }

}

class Utils{

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER =
            "root";
    private static final String PASSWORD =
            "";

    public static void migrate(){
        createTableMahasiswa();
        createTableDosen();
        createTableJoinedId();
        addConstraintForeignKey();
    }
    
    private static void createTableMahasiswa(){
        try { 
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement statement = conn.createStatement();
            String sql="CREATE TABLE mahasiswa ("+
                    "nim INT(11) not null PRIMARY KEY auto_increment," +
                    "nama_mhs VARCHAR(255) not null," +
                    "jurusan VARCHAR(255) not null,"+
                    "gender VARCHAR(255) not null,"+
                    "tgl_masuk DATE not null"+
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Sukses"+conn);
        } catch (SQLException ex) {
            System.out.println("GAGAL KONEKSI");
            Logger.getLogger(TransactionToJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void createTableDosen(){
        try { 
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement statement = conn.createStatement();
            String sql="CREATE TABLE dosen ("+
                    "nip INT(30) not null PRIMARY KEY auto_increment," +
                    "nama_dosen VARCHAR(255) not null," +
                    "jurusan_ajar VARCHAR(255) not null,"+
                    "nama_matkul VARCHAR(255) not null,"+
                    "gender VARCHAR(255) not null,"+
                    "tgl_masuk DATE not null"+
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Sukses"+conn);
        } catch (SQLException ex) {
            System.out.println("GAGAL KONEKSI");
            Logger.getLogger(TransactionToJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private static void createTableJoinedId(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE joined_id_meissa ( " +
                    "   id_joined INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nim INT(11) not null , " +
                    "   nip INT(30) not null  " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE JOINED_ID SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE JOINED_ID FAILED ");
            e.printStackTrace();
        }
    }
     
     private static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " alter table joined_id_meissa add constraint " +
                    " fk_tabel_mahasiswa foreign key (nim) references mahasiswa (nim) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_meissa add constraint " +
                    " fk_tabel_dosen foreign key (nip) references dosen (nip) ";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e){
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();
        }
    }
}
