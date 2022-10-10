/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class DBSoal {

    private ModelSoal dt = new ModelSoal();
    public ModelSoal getModelSoal(){ return(dt);}
    public void setModelSoal(ModelSoal s){ dt=s;}

    public ObservableList<ModelSoal> Load() {
        try {
            ObservableList<ModelSoal> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select soal_id, soal_isi, jawab_id, nilai from soal");
            int i = 1;
            while (rs.next()) {
                ModelSoal d = new ModelSoal();
                d.setSoal_id(rs.getInt("soal_id"));
                d.setSoal_isi(rs.getString("soal_isi"));
                d.setJawab_id(rs.getInt("jawab_id"));
                d.setNilai(rs.getInt("nilai"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(Integer nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from soal where soal_id = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into soal (soal_id, soal_isi,jawab_id,nilai) values (?,?,?,?)");
            con.preparedStatement.setInt(1, getModelSoal().getSoal_id());
            con.preparedStatement.setString(2, getModelSoal().getSoal_isi());
            con.preparedStatement.setInt(3, getModelSoal().getJawab_id());
            con.preparedStatement.setInt(4, getModelSoal().getNilai());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from soal where soal_id  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update soal set soal_isi= ?,jawab_id = ?, nilai = ? where soal_id = ?;");
            con.preparedStatement.setString(1, getModelSoal().getSoal_isi());
            con.preparedStatement.setInt(2, getModelSoal().getJawab_id());
            con.preparedStatement.setInt(3, getModelSoal().getNilai());
            con.preparedStatement.setInt(4, getModelSoal().getSoal_id());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

}
