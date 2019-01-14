import java.sql.*;

public class PuspaFlashback {

    //  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        Utils.createTableSatu();
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

    public static void createTableSatu() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE pohon ("+
                    "id_pohon INT(11) not null PRIMARY KEY auto_increment," +
                    "nama VARCHAR(255) not null," +
                    "jenispohon BIT not null," +
                    "jumlahdaun INT(11) not null," +
                    "jumlahbuah INT(11) not null," +
                    "tanggaltanam DATE not null"+
                    ")";
            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA: " +conn);
        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED ");
            e.printStackTrace();
        }
    }
}

