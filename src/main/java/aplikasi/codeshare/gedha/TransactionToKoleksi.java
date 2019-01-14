package main.java.aplikasi.codeshare.gedha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionToKoleksi{
    public static void main(String[]args){
        Utils.migrate();
    }

}

class Utils{
    public static final String DB_URL  ="jdbc:mysql://localhost/belajar_jdbc";
    public static final String USER    ="root";
    public static final String PASS    ="";

    public static void migrate(){
        createTabelSatu();
        createTabelDua();
        createTabelTiga();
        createTabelJoinedId();
        addConstraintForeignKey();
    }

    private static void createTabelSatu(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String sql ="CREATE TABLE tabel_buku("+
                    "id_buku INT(11) not null PRIMARY KEY auto_increment,"+
                    "judul_buku VARCHAR (255) not null,"+
                    "pengarang VARCHAR (255) not null,"+
                    "tanggal_terbit DATE not null"+
                    ")";
            stmt.executeUpdate(sql);
            System.out.println("Database pertama berhasil dibuat");
        }catch (SQLException e){
            System.out.println("Database gagal dibuat");
            e.printStackTrace();
        }
    }

    private static void createTabelDua(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String sql ="CREATE TABLE tabel_komik("+
                    "id_komik INT(11) not null PRIMARY KEY auto_increment,"+
                    "judul_komik VARCHAR (255) not null,"+
                    "pengarang VARCHAR (255) not null,"+
                    "tanggal_terbit DATE not null"+
                    ")";
            stmt.executeUpdate(sql);
            System.out.println("Database kedua berhasil dibuat");
        }catch (SQLException e){
            System.out.println("Database gagal dibuat");
            e.printStackTrace();
        }
    }

    private static void createTabelTiga(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String sql ="CREATE TABLE tabel_majalah("+
                    "id_majalah INT(11) not null PRIMARY KEY auto_increment,"+
                    "judul_majalah VARCHAR (255) not null,"+
                    "pengarang VARCHAR (255) not null,"+
                    "tanggal_terbit DATE not null"+
                    ")";
            stmt.executeUpdate(sql);
            System.out.println("Database ketika berhasil dibuat");
        }catch (SQLException e){
            System.out.println("Database gagal dibuat");
            e.printStackTrace();
        }
    }

    private static void createTabelJoinedId(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE joined_id ( " +
                    "   id_joined_id INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_buku INT(11) not null , " +
                    "   id_komik INT(11) not null , " +
                    "   id_majalah INT(11) not null  " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE JOIN_ID SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE JOIN_ID FAILED ");
            e.printStackTrace();
        }
    }

    private static void addConstraintForeignKey(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt= conn.createStatement();
            //Buku
            String sql="alter table joined_id add constraint "+
                    "fk_tabel_buku foreign key(id_buku) references table_buku (id_buku)";
            stmt.executeUpdate(sql);
            //Komik
            sql="alter table joined_id add constraint "+
                    "fk_tabel_komik foreign key(id_komik) references table_komik (id_komik)";
            stmt.executeUpdate(sql);
            //Join
            sql="alter table tabel_join_gedha add constraint "+
                    "fk_tabel_join_gedha foreign key(id_koleksi) references tabel_join_gedha (id_koleksi)";
            stmt.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e){
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();

        }
    }

}




