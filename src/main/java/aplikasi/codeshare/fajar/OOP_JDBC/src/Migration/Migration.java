package Migration;
import Config.ConnectionDB;
import java.sql.SQLException;

import Service.ObatRelationService;
import Service.ObatService;

import javax.swing.*;

public class Migration {
    public static void main(String[] args) throws SQLException{
        ObatRelationService obatRelationService = new ObatRelationService(ConnectionDB.getKoneksi());
        try {
            obatRelationService.migrate();
            JOptionPane.showMessageDialog(null,"Migrasi Data Berhasi","Succees!",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
