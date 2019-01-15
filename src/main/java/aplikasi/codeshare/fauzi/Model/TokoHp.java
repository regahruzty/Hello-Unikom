/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.sql.DataSource;
import static main.java.aplikasi.codeshare.fauzi.Model.Model.conn;
import static main.java.aplikasi.codeshare.fauzi.Model.Model.sql;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;

/**
 *
 * @author acer
 */
public class TokoHp extends Model {
    
    public Toko Toko = new Toko();
    public Smartphone Smartphone = new Smartphone();
    private int id;
    protected String table = "toko_hp";

    
    public TokoHp(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Toko getToko() {
        return Toko;
    }

    public void setToko(Toko Toko) {
        this.Toko = Toko;
    }

    public Smartphone getSmartphone() {
        return Smartphone;
    }

    public void setSmartphone(Smartphone Smartphone) {
        this.Smartphone = Smartphone;
    }

    @Override
    public String toString() {
        return "TokoHp{" + "Toko=" + Toko + ", Smartphone=" + Smartphone + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.Toko);
        hash = 37 * hash + Objects.hashCode(this.Smartphone);
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TokoHp other = (TokoHp) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Toko, other.Toko)) {
            return false;
        }
        if (!Objects.equals(this.Smartphone, other.Smartphone)) {
            return false;
        }
        return true;
    }

    public TokoHp insert() throws SQLException{
        
        int generatedId =0;
        sql = "insert into toko_hp(smartphone_id,toko_id)"
                + "values(?,?)";
        conn = ds.getConnection();
        ps = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);


        ps.setInt(1, this.Smartphone.getId());
        ps.setInt(2, this.Toko.getId());

        ps.executeUpdate();

        ResultSet getGeneratedKeys = ps.getGeneratedKeys();
        while (getGeneratedKeys.next()) {
            generatedId = getGeneratedKeys.getInt(1);
        }

        this.id = generatedId;

        getGeneratedKeys.close();
        ps.close();
        conn.close();
        
        return this;
    }
    
    public TokoHp update(TokoHp tokoHp) throws SQLException{
        conn = ds.getConnection();

        String sql = "update toko_hp set id_smartphone = ?, id_toko = ? where id = ?";

        ps = conn.prepareStatement(sql);
        ps.setLong(1, tokoHp.Smartphone.getId());
        ps.setLong(2, tokoHp.Toko.getId());
        ps.setLong(3, id);

        ps.executeUpdate();

        ps.close();
        conn.close();
        
        return tokoHp;
    }
    
    public List<TokoHp> all() throws SQLException{
        List<TokoHp> tokoHps = new ArrayList<>();

        conn = ds.getConnection();
        stmt = conn.createStatement();

        String sql = "select * from toko_hp th join smartphone on th.smartphone_id=smartphone.id "
                + "join toko on th.toko_id=toko.id";

        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            TokoHp th = new TokoHp();
            th.setId(resultSet.getInt("id"));
            th.Smartphone.setId(Integer.parseInt(resultSet.getString("smartphone.id")));
            th.Toko.setId(Integer.parseInt(resultSet.getString("toko.id")));
            th.Toko.setProvince(resultSet.getString("province"));
            th.Toko.setPhone(resultSet.getString("phone"));
            th.Smartphone.setMerk(resultSet.getString("merk"));
            th.Smartphone.setRam(Integer.parseInt(resultSet.getString("ram")));
            th.Smartphone.setCamera(Integer.parseInt(resultSet.getString("camera")));
            tokoHps.add(th);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return tokoHps;
    }
}
