/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLDisplayTerjawabController implements Initializable {

    @FXML
    private TableView<ModelTerjawab> tbvTerjawab;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
    }    
    private void showdata() {
        ObservableList<ModelTerjawab> data = FXMLDocumentController.dtterjawab.Load();
        if (data != null) {
            tbvTerjawab.getColumns().clear();
            tbvTerjawab.getItems().clear();
            TableColumn col = new TableColumn("soal_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelTerjawab, String>("soal_id"));
            tbvTerjawab.getColumns().addAll(col);
            col = new TableColumn("nilai");
            col.setCellValueFactory(new PropertyValueFactory<ModelTerjawab, String>("nilai"));
            tbvTerjawab.getColumns().addAll(col);
            tbvTerjawab.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvTerjawab.getScene().getWindow().hide();
        }
    }
    @FXML
    private void klikawal(ActionEvent event) {
        tbvTerjawab.getSelectionModel().selectFirst();
        tbvTerjawab.requestFocus();
    }

    @FXML
    private void klikakhir(ActionEvent event) {
        tbvTerjawab.getSelectionModel().selectLast();
        tbvTerjawab.requestFocus();
    }

    @FXML
    private void kliksebelum(ActionEvent event) {
        tbvTerjawab.getSelectionModel().selectAboveCell();
        tbvTerjawab.requestFocus();
    }

    @FXML
    private void kliksesudah(ActionEvent event) {
        tbvTerjawab.getSelectionModel().selectBelowCell();
        tbvTerjawab.requestFocus();
    }

    @FXML
    private void klikkeluar(ActionEvent event) {
    }
    
}
