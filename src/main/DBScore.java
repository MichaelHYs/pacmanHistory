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
public class DBScore {
    private ModelScore dt = new ModelScore();
    public ModelScore getModelScore(){ return(dt);}
    public void setModelScore(ModelScore s){ dt=s;}
    
    public ObservableList<ModelScore> Load() {
        try {
            ObservableList<ModelScore> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select sum(nilai) as score from soal");
            int i = 1;
            while (rs.next()) {
                ModelScore d = new ModelScore();
                d.setScore(rs.getInt("score"));
                d.setUser(rs.getString("user"));
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
