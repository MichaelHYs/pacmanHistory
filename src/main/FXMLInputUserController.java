/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLInputUserController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;

    boolean editdata = false;

    public void execute(ModelUser d) {
        if (!d.getUser_id().isEmpty()) {
            editdata = true;
            txtUser.setText(d.getUser_id());
            txtName.setText(d.getName());
            txtUser.setEditable(false);
            txtName.requestFocus();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void klikBatal(ActionEvent event) {
        txtUser.setText("");
        txtName.setText("");
    }

    @FXML
    private void klikKeluar(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }

    @FXML
    private void klikSimpan(ActionEvent event) {
        ModelUser s = new ModelUser();
        s.setUser_id(txtUser.getText());
        s.setName(txtName.getText());
        FXMLDocumentController.dtuser.setModelUser(s);
        if (editdata) {
            if (FXMLDocumentController.dtuser.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtUser.setEditable(true);
                klikBatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtuser.validasi(s.getUser_id()) <= 0) {
            if (FXMLDocumentController.dtuser.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                klikBatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtUser.requestFocus();
        }

    }

}

