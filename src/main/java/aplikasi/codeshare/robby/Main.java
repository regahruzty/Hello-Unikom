package main.java.aplikasi.codeshare.robby;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main{
    //jdbc driver
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/learn_komputer";

    //db credentials
    static final String USER = "root";
    static final String PASS = "root";

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
            sql = "select komputer.nama, komputer.procie, tipe.nama, pemilik.nama from komputer join tipe on komputer.id_tipe = tipe.id_tipe join pemilik on komputer.id_komputer = pemilik.id_komputer;";
            ResultSet rs = stmt.executeQuery(sql);
            List<Komputer> komputerList = new ArrayList<>();

            while(rs.next()){
                //Retrieve by column name
                Pemilik motor = new Pemilik();
                Tipe tipe = new Tipe();
                Komputer komputer = new Komputer();

                System.out.println(rs.getString("nama"));
                System.out.println(rs.getString("procie"));
            }

            //Display values
            /*for (Komputer komputer : komputerList) {

            }*/
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
    }
}

class Komputer {

    //variabel komputer
    private int id_komputer;
    private String nama;
    private String processor;
    private String mainboard;
    private String Memory;
    private String monitor;
    private boolean keyMouse;
    private Date tanggalBangun;

    //konstruktor dengan args


    public Komputer(int id_komputer, String nama, String processor, String mainboard, String memory, String monitor, boolean keyMouse, Date tanggalBangun) {
        this.id_komputer = id_komputer;
        this.nama = nama;
        this.processor = processor;
        this.mainboard = mainboard;
        Memory = memory;
        this.monitor = monitor;
        this.keyMouse = keyMouse;
        this.tanggalBangun = tanggalBangun;
    }

    //komstruktor kosong
    public Komputer(){}

    //getter dan setter


    public int getId_komputer() {
        return id_komputer;
    }

    public void setId_komputer(int id_komputer) {
        this.id_komputer = id_komputer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public boolean isKeyMouse() {
        return keyMouse;
    }

    public void setKeyMouse(boolean keyMouse) {
        this.keyMouse = keyMouse;
    }

    public Date getTanggalBangun() {
        return tanggalBangun;
    }

    public void setTanggalBangun(Date tanggalBangun) {
        this.tanggalBangun = tanggalBangun;
    }
}

class Server extends Komputer{
    public Server(){
        setNama("server1");
        setProcessor("xeon");
        setMainboard("intel");
        setMemory("16GB");
        setTanggalBangun(new Date());
        setKeyMouse(false);

    }

    public void describe(){
        System.out.println("nama komputer: "+new Server().getNama());
    }

    public void describe(String milik){
        System.out.println("nama komputer: "+new Server().getNama());
        System.out.println("kucing ini milik: "+ milik);
    }
}

class Pemilik {
    private int id_pemilik;
    private String nama_pemilik;

    public Pemilik(int id_pemilik, String nama_pemilik) {
        this.id_pemilik = id_pemilik;
        this.nama_pemilik = nama_pemilik;
    }

    public Pemilik(){}

    public int getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(int id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }
}

class Tipe {
    private int id_tipe;
    String nama_tipe;

    public Tipe(int id_tipe, String nama_tipe) {
        this.id_tipe = id_tipe;
        this.nama_tipe = nama_tipe;
    }

    public  Tipe(){}

    public int getId_tipe() {
        return id_tipe;
    }

    public void setId_tipe(int id_tipe) {
        this.id_tipe = id_tipe;
    }

    public String getNama_tipe() {
        return nama_tipe;
    }

    public void setNama_tipe(String nama_tipe) {
        this.nama_tipe = nama_tipe;
    }
}