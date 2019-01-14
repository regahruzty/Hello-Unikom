package main.java.aplikasi.codeshare.puspa;
import java.sql.*;

public class TransictionToJDBC {

        //  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

        public static void main(String[] args) {

            Connection conn = null;
            Statement statement = null;
            Utils.migrate();
            //   System.out.println("INI DRIVER JDBC SAYA: " +DRIVER);

            //supaya error ke handle, pakai try and catcth ini
            //error itu misal databsenya gak ada, ngetik usernya typo
            //try and catch bakal ngasih tau errornya di mana
            //kalau gak pakai try and catch , gak tau errornya di mana

        }
    }

    //perintah2:
    class Utils {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/belajar_jdbc";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        static void migrate() {
            createTableSatu();
            createTableDua();
            createTableJoinedId();
            addConstraintForeignKey();
        }

        public static void createTableSatu() {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                String sql = "CREATE TABLE pohon1 (" +
                        "id_pohon1 INT(11) not null PRIMARY KEY auto_increment," +
                        "nama VARCHAR(255) not null," +
                        "jenispohon BIT not null," +
                        "jumlahdaun INT(11) not null," +
                        "jumlahbuah INT(11) not null," +
                        "tanggaltanam DATE not null" +
                        ")";
                statement.executeUpdate(sql);
                System.out.println("CREATE TABLE POHON1 SUCCESS ");
            } catch (SQLException e) {
                System.out.println("CREATE TABLE POHON1 FAILED ");
                e.printStackTrace();
            }
        }

        private static void createTableDua() {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                String sql = "CREATE TABLE harga (" +
                        "id_harga INT(11) not null PRIMARY KEY auto_increment," +
                        "beratbuah INT(11) not null," +
                        "harga INT(11) not null," +
                        "tanggalbeli DATE not null" +
                        ")";
                statement.executeUpdate(sql);
                System.out.println("CREATE TABLE HARGA SUCCESS ");
            } catch (SQLException e) {
                System.out.println("CREATE TABLE HARGA FAILED ");
                e.printStackTrace();
            }
        }


        private static void createTableJoinedId() {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                String sql = " CREATE TABLE joined_id_puspa ( " +
                        "   id_joined_puspa INT(11) not null PRIMARY KEY auto_increment, " +
                        "   id_pohon1 INT(11) not null , " +
                        "   id_harga INT(11) not null " +
                        "   )";
                statement.executeUpdate(sql);
                System.out.println("CREATE TABLE JOINED_ID_PUSPA SUCCESS ");
            } catch (SQLException e) {
                System.out.println("CREATE TABLE JOINED_ID_PUSPA FAILED ");
                e.printStackTrace();
            }
        }

        private static void addConstraintForeignKey() {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                String sql = " alter table joined_id_puspa add constraint " +
                        " fk_pohon1 foreign key (id_pohon1) references pohon1 (id_pohon1) ";
                statement.executeUpdate(sql);
                sql = " alter table joined_id_puspa add constraint " +
                        " fk_harga foreign key (id_harga) references harga (id_harga) ";
                statement.executeUpdate(sql);
                System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
            } catch (SQLException e) {
                System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
                e.printStackTrace();
            }
        }
    }
