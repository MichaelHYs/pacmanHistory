/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLDisplayUserController implements Initializable {

    @FXML
    private TableView<ModelUser> tbvuser;
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
        ObservableList<ModelUser> data = FXMLDocumentController.dtuser.Load();
        if (data != null) {
            tbvuser.getColumns().clear();
            tbvuser.getItems().clear();
            TableColumn col = new TableColumn("user_id");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("user_id"));
            tbvuser.getColumns().addAll(col);
            col = new TableColumn("name");
            col.setCellValueFactory(new PropertyValueFactory<ModelUser, String>("name"));
            tbvuser.getColumns().addAll(col);
            tbvuser.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvuser.getScene().getWindow().hide();
        }
    }

    @FXML
    private void klikawal(ActionEvent event) {
        tbvuser.getSelectionModel().selectFirst();
        tbvuser.requestFocus();
    }

    @FXML
    private void klikakhir(ActionEvent event) {
        tbvuser.getSelectionModel().selectLast();
        tbvuser.requestFocus();
    }

    @FXML
    private void kliksebelum(ActionEvent event) {
        tbvuser.getSelectionModel().selectAboveCell();
        tbvuser.requestFocus();
    }

    @FXML
    private void kliksesudah(ActionEvent event) {
        tbvuser.getSelectionModel().selectBelowCell();
        tbvuser.requestFocus();
    }

    @FXML
    private void kliktambah(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputUser.fxml"));
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
        ModelUser s = new ModelUser();
        s = tbvuser.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtuser.delete(s.getUser_id())) {
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
        ModelUser s = new ModelUser();
        s = tbvuser.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInputUser.fxml"));
            Parent root = (Parent) loader.load();
            FXMLInputUserController isidt = (FXMLInputUserController) loader.getController();
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
