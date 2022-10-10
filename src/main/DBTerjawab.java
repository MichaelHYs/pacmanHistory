/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class DBTerjawab {
    private ModelTerjawab dt = new ModelTerjawab();
    public ModelTerjawab getModelTerjawab(){ return(dt);}
    public void setModelTerjawab(ModelTerjawab s){ dt=s;}
    
    public ObservableList<ModelTerjawab> Load() {
        try {
            ObservableList<ModelTerjawab> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select n.soal_id, nilai as nilai from terjawab n inner join soal s on n.soal_id=s.soal_id;");
            int i = 1;
            while (rs.next()) {
                ModelTerjawab d = new ModelTerjawab();
                d.setSoal_id(rs.getInt("soal_id"));
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
}
