package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Migration;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TNIService;

import javax.sql.DataSource;
import java.io.UTFDataFormatException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration {

    public static void main(String[] args) throws SQLException{
        Utils utils = new Utils(KoneksiDB.getKoneksi());
        utils.migrate();
        System.out.println("MIGRATION DATABASE TNI COMPLETED!");
    }

}
 class Utils{
     private DataSource dataSource;

     public Utils(DataSource dataSource) {
         this.dataSource = dataSource;
     }

    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE tni (" +
                " id_tni bigint not null primary key auto_increment, " +
                " id_tentara bigint not null," +
                " id_batalyon bigint not null," +
                " id_tentara_aktif bigint not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE tentara (" +
                " id_tentara bigint not null primary key auto_increment, " +
                " nama_tentara varchar(255) not null," +
                " pangkat varchar(255) not null," +
                " matra varchar(255) not null," +
                " is_perwira bit(1) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE tentara_aktif (" +
                " id_tentara_aktif bigint not null primary key auto_increment, " +
                " status_tentara varchar(255) not null)";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE batalyon (" +
                " id_batalyon bigint not null primary key auto_increment, " +
                " nama_batalyon varchar(255) not null)";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_tentara " +
                " foreign key (id_tentara) references tentara (id_tentara) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_tentaraaktif " +
                " foreign key (id_tentara_aktif) references tentara_aktif (id_tentara_aktif) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_batalyon " +
                " foreign key (id_batalyon) references batalyon (id_batalyon) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
