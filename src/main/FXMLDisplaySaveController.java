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
public class FXMLDisplaySaveController implements Initializable {

    @FXML
    private TableView<ModelSave> tbvsave;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
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
        ObservableList<ModelSave> data = FXMLDocumentController.dtsave.Load();
        if (data != null) {
            tbvsave.getColumns().clear();
            tbvsave.getItems().clear();
            TableColumn col = new TableColumn("save_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("save_id"));
            tbvsave.getColumns().addAll(col);
            col = new TableColumn("user_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("user_id"));
            tbvsave.getColumns().addAll(col);
            col = new TableColumn("soal_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("soal_id"));
            tbvsave.getColumns().addAll(col);
            col = new TableColumn("score");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("score"));
            tbvsave.getColumns().addAll(col);
            tbvsave.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvsave.getScene().getWindow().hide();
        }
    }

    @FXML
    private void klikawal(ActionEvent event) {
    }

    @FXML
    private void klikakhir(ActionEvent event) {
    }

    @FXML
    private void kliksebelum(ActionEvent event) {
    }

    @FXML
    private void kliksesudah(ActionEvent event) {
    }

    @FXML
    private void klikkeluar(ActionEvent event) {
    }
    
}
