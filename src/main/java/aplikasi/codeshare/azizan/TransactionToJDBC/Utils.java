package main.java.aplikasi.codeshare.azizan.TransactionToJDBC;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Azizan{
    private static final String DB_URL =
            "jdbc:mysql://localhost/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";

    public static void Migrate(){
        createTabelTentara();
        createTabelBatalyon();
        createTabelTentaraAktif();
        createTabelTNI();
        addConstraintForeignKey();
    }

    public static void createTabelBatalyon(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `batalyon` (" +
                    "  `id_batalyon` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "  `id_tentara` int(11) NOT NULL," +
                    "  `jabatan` varchar(50) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE BATALYON SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE BATALYON ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelTentara(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `tentara` (" +
                    "  `id_tentara` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "  `nama` varchar(50) NOT NULL," +
                    "  `umur` int(5) NOT NULL," +
                    "  `tanggal_lahir` date NOT NULL," +
                    "  `alamat` varchar(100) NOT NULL," +
                    "  `matra` varchar(50) NOT NULL," +
                    "  `is_perwira` bit(1) NOT NULL," +
                    "  `pangkat` varchar(50) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TENTARA SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE TENTARA ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelTentaraAktif(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `tentara_aktif` (" +
                    "  `id_tentara_aktif` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "  `id_tentara` int(11) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TENTARA AKTIF SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE TENTARA AKTIF ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelTNI(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `tni` (" +
                    "  `id_tni` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "  `id_tentara` int(11) NOT NULL," +
                    "  `id_tentara_aktif` int(11) NOT NULL," +
                    "  `id_batalyon` int(11) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TNI SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE TNI ERROR!");
            e.printStackTrace();
        }
    }

    public static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "ALTER TABLE tni ADD FOREIGN KEY (id_tentara) REFERENCES tentara(id_tentara)";
            statement.executeUpdate(sql);
            sql = "ALTER TABLE tni ADD FOREIGN KEY (id_tentara_aktif) REFERENCES tentara_aktif(id_tentara_aktif)";
            statement.executeUpdate(sql);
            sql = "ALTER TABLE tni ADD FOREIGN KEY (id_batalyon) REFERENCES batalyon(id_batalyon)";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY SUKSES!");

        } catch (SQLException e) {
            System.out.println("ADD FOREIGN KEY ERROR!");
            e.printStackTrace();
        }
    }
    /*public static void createTabelAnjing(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `anjing` (" +
                    "  `id_anjing` int(2) NOT NULL," +
                    "  `nama` varchar(20) NOT NULL," +
                    "  `jenis` enum('pitbul','husky','pug','buldog','chow chow','pudel') NOT NULL," +
                    "  `kebiasaan` varchar(25) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE NARASI SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE ANJING ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelObat(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `obat` (" +
                    "  `id_obat` int(11) NOT NULL," +
                    "  `nama_obat` varchar(255) DEFAULT NULL," +
                    "  `dosis` varchar(255) DEFAULT NULL," +
                    "  `Keterangan` varchar(255) DEFAULT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE OBAT SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE OBAT ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelTentara(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `tentara` (" +
                    "  `id_tentara` int(11) NOT NULL," +
                    "  `nama` varchar(255) NOT NULL," +
                    "  `matra` varchar(255) NOT NULL," +
                    "  `pangkat` varchar(255) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TENTARA SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE TENTARA ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelSmartphone(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `smartphone` (" +
                    "  `id_smartphone` int(5) NOT NULL," +
                    "  `merk` varchar(25) NOT NULL," +
                    "  `type` varchar(25) NOT NULL," +
                    "  `ram` int(2) NOT NULL," +
                    "  `camera` int(2) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE SMARTPHONE SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE SMARTPHONE ERROR!");
            e.printStackTrace();
        }
    }

    public static void createTabelNarasi(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE `narasi` (" +
                    "  `id_narasi` int(11) NOT NULL," +
                    "  `id_tentara` int(11) NOT NULL," +
                    "  `id_anjing` int(2) NOT NULL," +
                    "  `id_obat` int(11) NOT NULL," +
                    "  `smartphone_id` int(5) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE NARASI SUKSES!");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE NARASI ERROR!");
            e.printStackTrace();
        }
    }

    public static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "ALTER TABLE `narasi`" +
                    "  ADD PRIMARY KEY (`id_narasi`)," +
                    "  ADD KEY `id_tentara` (`id_tentara`)," +
                    "  ADD KEY `id_anjing` (`id_anjing`)," +
                    "  ADD KEY `id_obat` (`id_obat`)," +
                    "  ADD KEY `smartphone_id` (`smartphone_id`);";
            statement.executeUpdate(sql);
            System.out.println("CREATE FOREIGN KEY SUKSES!");

        } catch (SQLException e) {
            System.out.println("CREATE FOREIGN KEY ERROR!");
            e.printStackTrace();
        }
    }*/


}

class Fauzi{
    public static final String DB_URL = "jdbc:mysql://localhost:3306/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void Migrate(){
        createTableSmartphone();
        createTableToko();
        createTableTokoHp();
    }
    public static void createTableSmartphone(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "drop table if EXISTS smartphone;";
            Statement statement = conn.createStatement();

            statement.execute(sql);

            sql =    "create table smartphone(" +
                    "    id int(11) not null primary key auto_increment," +
                    "    merk varchar(15) not null," +
                    "    type varchar(15) not null," +
                    "    ram int(2) not null," +
                    "    camera int(2) not null" +
                    "    );";

            statement.execute(sql);
            System.out.println("Create table smartphone success");
        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table Smartphone Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }
    public static void createTableToko(){
        try{

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();

            String sql = "drop table if EXISTS toko;";
            statement.execute(sql);

            sql = "Create table toko("
                    + "id int(11) not null primary key auto_increment,"
                    + "name varchar(50) not null,"
                    + "province varchar(25) not null,"
                    + "phone char(15) not null"
                    + ");";
            statement.execute(sql);


            System.out.println("create Table Toko Success");
        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table Toko Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }
    public static void createTableTokoHp(){
        try{

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();

            String sql = "drop table if EXISTS toko_hp;";
            statement.execute(sql);

            sql = "Create table toko_hp("
                    + "id int(11) not null primary key auto_increment,"
                    + "toko_id int(11) not null,"
                    + "smartphone_id int(11) not null"
                    + ");";
            statement.execute(sql);
            System.out.println("create Table Toko HP Success");

// foreign key -> toko
            sql = "alter table toko_hp add foreign key (toko_id)"
                    + "references toko(id);";
            statement.execute(sql);
            System.out.println("create foreign key toko_id Success");

// foreign key -> smartphone
            sql = "alter table toko_hp add foreign key (smartphone_id)"
                    + "references smartphone(id);";
            statement.execute(sql);
            System.out.println("create foreign key smartphone_id Success");

        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table toko_hp Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }

}