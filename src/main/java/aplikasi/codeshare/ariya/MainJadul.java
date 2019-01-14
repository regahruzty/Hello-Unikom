package main.java.aplikasi.codeshare.ariya;


public class MainJadul {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://127.0.0.1/boothcamp";
//
//    static final String USER = "root";
//    static final String PASS = "";
//
//    static Scanner input = new Scanner(System.in);
//    static Motor motor = new Motor();
//    static Pembeli pembeli = new Pembeli();
//    static Transaksi transaksi = new Transaksi();
//    static List<Transaksi> transaksiList = new ArrayList<>();
//
//
//
//    java.util.Date date = new java.util.Date();
//    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//
//    public static void main(String[] args) {
//
//
//
//        System.out.println("Aplikasi Dealer");
//        System.out.println("PILIH MENU: ");
//        System.out.println("1 = INPUT, " + "2 = OUTPUT ");
//
//
//        int pilihMenu = input.nextInt();
//        if (pilihMenu == 1) {
//            System.out.println("PILIH MENU INPUT: ");
//            System.out.println("1 = INPUT MOTOR, 2 = INPUT PEMBELI, 3 INPUT TRANSAKSI");
//            pilihMenu = input.nextInt();
//            if (pilihMenu == 1) {
//                inputMotor();
//            } else if(pilihMenu == 2){
//                inputPembeli();
//            } else if(pilihMenu == 3){
//                inputTransaksi();
//            } else{
//                System.out.println("Sistem Error");
//            }
//        } else if (pilihMenu == 2) {
//            System.out.println("PILIH MENU OUTPUT: ");
//            System.out.println("1 = OUTPUT MOTOR, 2 = OUTPUT PEMBELI, 3 OUTPUT TRANSAKSI");
//            pilihMenu = input.nextInt();
//            if (pilihMenu == 1) {
//                viewMotor();
//            } else if(pilihMenu == 2){
//                viewPembeli();
//            } else if(pilihMenu == 3){
//                viewTransaksi();
//            } else{
//                System.out.println("Sistem Error");
//            }
//        }
//    }
//
//
//    static void inputTransaksi(){
//
//        System.out.println("INPUT TRANSAKSI");
//        System.out.print("Masukkan ID Pembeli : ");
//        pembeli.setId_pembeli(input.nextInt());
//        System.out.print("Masukkan ID Motor : ");
//        motor.setId_motor(input.nextInt());
//        System.out.print("Masukkan Tanggal (YYYY-MM-DD) : ");
//        transaksi.setTanggal_pembelian(input.next());
//        System.out.print("Masukkan Jumlah Pembelian: ");
//        transaksi.setJumlah_pembelian(input.nextInt());
//
//        transaksi.setId_pembeli(pembeli);
//        transaksi.setId_motor(motor);
//
//        transaksiList.add(transaksi);
//        tambahTransaksi();
//    }
//    static void inputPembeli(){
//        System.out.println("INPUT PEMBELI");
//        System.out.print("Masukkan Nama Pembeli : ");
//        pembeli.setNama_pembeli(input.next());
//        System.out.print("Masukkan Pekerjaan : ");
//        pembeli.setPekerjaan(input.next());
//        System.out.print("Masukkan Alamat Pembeli: ");
//        pembeli.setAlamat(input.next());
//    }
//    static void inputMotor(){
//        System.out.println("INPUT MOTOR");
//        System.out.print("Masukkan Merk Motor : ");
//        motor.setMerk_motor(input.next());
//        System.out.print("Masukkan Nama Motor : ");
//        motor.setNama_motor(input.next());
//        System.out.print("Masukkan Harga Motor: ");
//        motor.setHarga(input.nextInt());
//    }
//
//
//    static void viewMotor(){
//        System.out.println("Under Construction");
//    }
//    static void viewPembeli() {
//        System.out.println("under construction");
//    }
//    static void viewTransaksi(){
//        Connection conn = null;
//        Statement stmt = null;
//
//
//        try{
//            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//
//            sql = "select * "
//                    + "from transaksi "
//                    + "join motor on transaksi.id_motor = motor.id_motor "
//                    + "join pembeli on transaksi.id_pembeli = pembeli.id_pembeli ORDER BY tanggal_pembelian ASC ";
//            ResultSet rs = stmt.executeQuery(sql);
//            List<Transaksi> transaksiList = new ArrayList<>();
//
//
//
//            while(rs.next()){
//                //Retrieve by column name
//                Transaksi transaksi = new Transaksi();
//                Motor motor = new Motor();
//                Pembeli pembeli = new Pembeli();
//                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
//                motor.setMerk_motor(rs.getString("merk_motor"));
//                motor.setNama_motor(rs.getString("nama_motor"));
//                motor.setHarga(rs.getInt("harga"));
//                pembeli.setNama_pembeli(rs.getString("nama_pembeli"));
//                transaksi.setJumlah_pembelian(rs.getInt("jumlah_pembelian"));
//                transaksi.setTanggal_pembelian(rs.getString("tanggal_pembelian"));
//                transaksi.setId_motor(motor);
//                transaksi.setId_pembeli(pembeli);
//
//                transaksiList.add(transaksi);
//
//
//
//                //Display values
//
//
//            }
//
//            for (Transaksi transaksi : transaksiList) {
//
//                System.out.println("======================================");
//                System.out.println("id_transaksi: " + transaksi.getId_transaksi());
//                System.out.println("merk_motor: " + transaksi.getId_motor().getMerk_motor());
//                System.out.println("nama_motor: " + transaksi.getId_motor().getNama_motor());
//                System.out.println("harga: " + transaksi.getId_motor().getHarga());
//                System.out.println("nama_pembeli: " + transaksi.getId_pembeli().getNama_pembeli());
//                System.out.println("jumlah_pembelian: " + transaksi.getJumlah_pembelian());
//                System.out.println("tanggal_pembelian: " + transaksi.getTanggal_pembelian());
//                System.out.println("======================================");
//
//
//            }
//            //STEP 6: Clean-up environmentga
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//        }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        }finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }
//    }
//
//
//    static void tambahTransaksi(){
//        Connection conn = null;
//        Statement stmt = null;
//
//
//        try{
//            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//
//            sql = "insert into transaksi (id_pembeli, id_motor, tanggal_pembelian, jumlah_pembelian) "
//                    + "values (?, ?, ?, ?) ";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            List<Transaksi> transaksiList = new ArrayList<>();
//
//            ps.setInt(1, transaksi.getId_pembeli().getId_pembeli());
//            ps.setInt(2, transaksi.getId_motor().getId_motor());
//            ps.setString(3, transaksi.getTanggal_pembelian());
//            ps.setInt(4, transaksi.getJumlah_pembelian());
//
//            ps.execute();
//            conn.close();
//
//            System.out.println("Data Telah Tersimpan");
//        }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//        }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        }finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }
//    }
//

}
