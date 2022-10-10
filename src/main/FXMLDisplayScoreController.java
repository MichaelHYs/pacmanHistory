/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLDisplayScoreController implements Initializable {

    @FXML
    private TableView<ModelScore> tbvscore;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsebelum;
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
        ObservableList<ModelScore> data = FXMLDocumentController.dtscore.Load();
        if (data != null) {
            tbvscore.getColumns().clear();
            tbvscore.getItems().clear();
            TableColumn col = new TableColumn("score");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("score"));
            tbvscore.getColumns().addAll(col);
            col = new TableColumn("user");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("user"));
            tbvscore.getColumns().addAll(col);
            tbvscore.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvscore.getScene().getWindow().hide();
        }
    }

    @FXML
    private void klikawal(ActionEvent event) {
        tbvscore.getSelectionModel().selectFirst();
        tbvscore.requestFocus();
    }

    @FXML
    private void klikakhir(ActionEvent event) {
        tbvscore.getSelectionModel().selectLast();
        tbvscore.requestFocus();
    }

    @FXML
    private void kliksebelum(ActionEvent event) {
        tbvscore.getSelectionModel().selectAboveCell();
        tbvscore.requestFocus();
    }

    @FXML
    private void kliksesudah(ActionEvent event) {
        tbvscore.getSelectionModel().selectBelowCell();
        tbvscore.requestFocus();
    }

    @FXML
    private void klikkeluar(ActionEvent event) {
    }
    
}
