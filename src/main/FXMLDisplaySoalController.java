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
public class FXMLDisplaySoalController implements Initializable {

    @FXML
    private TableView<ModelSoal> tbvsoal;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
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
        ObservableList<ModelSoal> data = FXMLDocumentController.dtsoal.Load();
        if (data != null) {
            tbvsoal.getColumns().clear();
            tbvsoal.getItems().clear();
            TableColumn col = new TableColumn("soal_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelSoal, String>("soal_id"));
            tbvsoal.getColumns().addAll(col);
            col = new TableColumn("soal_isi");
            col.setCellValueFactory(new PropertyValueFactory<ModelSoal, String>("soal_isi"));
            tbvsoal.getColumns().addAll(col);
            col = new TableColumn("jawab_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelSoal, String>("jawab_id"));
            tbvsoal.getColumns().addAll(col);
            col = new TableColumn("nilai");
            col.setCellValueFactory(new PropertyValueFactory<ModelSoal, String>("nilai"));
            tbvsoal.getColumns().addAll(col);
            tbvsoal.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvsoal.getScene().getWindow().hide();
        }
    }

    @FXML
    private void klikawal(ActionEvent event) {
        tbvsoal.getSelectionModel().selectFirst();
        tbvsoal.requestFocus();
    }

    @FXML
    private void klikakhir(ActionEvent event) {
        tbvsoal.getSelectionModel().selectLast();
        tbvsoal.requestFocus();
    }

    @FXML
    private void kliksebelum(ActionEvent event) {
        tbvsoal.getSelectionModel().selectAboveCell();
        tbvsoal.requestFocus();
    }

    @FXML
    private void kliksesudah(ActionEvent event) {
        tbvsoal.getSelectionModel().selectBelowCell();
        tbvsoal.requestFocus();
    }

    @FXML
    private void kliktambah(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputSoal.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void klikhapus(ActionEvent event) {
        ModelSoal s = new ModelSoal();
        s = tbvsoal.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtsoal.delete(Integer.toString(s.getSoal_id()))) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showdata();
            klikawal(event);
        }
    }

    @FXML
    private void klikubah(ActionEvent event) {
        ModelSoal s = new ModelSoal();
        s = tbvsoal.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputSoal.fxml"));
            Parent root = (Parent) loader.load();
            FXMLInputSoalController isidt = (FXMLInputSoalController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
        klikawal(event);
    }

    @FXML
    private void klikkeluar(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }
    
}
