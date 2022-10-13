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
public class DBSave {

    private ModelSave dt = new ModelSave();

    public ModelSave getModelSave() {
        return (dt);
    }

    public void setModelSave(ModelSave s) {
        dt = s;
    }

    public ObservableList<ModelSave> Load() {
        try {
            ObservableList<ModelSave> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "SELECT save_id, user.user_id, soal.soal_id, user.score\n"
                    + "FROM ((save \n"
                    + "INNER JOIN user ON save.user_id = user.user_id)\n"
                    + "INNER JOIN soal ON save.soal_id = soal.soal_id);\n"
                    + "");
            int i = 1;
            while (rs.next()) {
                ModelSave d = new ModelSave();
                d.setSave_id(rs.getInt("save_id"));
                d.setUser_id(rs.getString("user_id"));
                d.setSoal_id(rs.getInt("soal_id"));
                d.setScore(rs.getInt("score"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from save where save_id = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into save (save_id) values (?)");
            con.preparedStatement.setInt(1, getModelSave().getSave_id());
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
