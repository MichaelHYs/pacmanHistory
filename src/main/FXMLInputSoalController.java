/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLInputSoalController implements Initializable {

    @FXML
    private TextArea txtSoal;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    @FXML
    private Slider sldNilai;
    @FXML
    private Label lblNilai;
    @FXML
    private Slider sldIdJawab;
    @FXML
    private Slider sldIdSoal;
    @FXML
    private Label lblJawab;
    @FXML
    private Label lblIdSoal;
    boolean editdata = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sldNilai.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                    Number oldVal, Number newVal) {
                lblNilai.setText(String.valueOf(newVal.intValue()));
            }
        });
        sldIdSoal.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                    Number oldVal, Number newVal) {
                lblIdSoal.setText(String.valueOf(newVal.intValue()));
            }
        });
        sldIdJawab.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                    Number oldVal, Number newVal) {
                lblJawab.setText(String.valueOf(newVal.intValue()));
            }
        });
    }

    public void execute(ModelSoal d) {
        if (!String.valueOf(d.getSoal_id()).isEmpty()) {
            editdata = true;
            sldIdSoal.setValue(d.getSoal_id());
            txtSoal.setText(d.getSoal_isi());
            sldIdJawab.setValue(d.getJawab_id());
            sldNilai.setValue(d.getNilai());
        } else {
        }
    }

    @FXML
    private void kliksimpan(ActionEvent event) {
        ModelSoal s = new ModelSoal();
        s.setSoal_id((int) sldIdSoal.getValue());
        s.setSoal_isi(txtSoal.getText());
        s.setJawab_id((int) sldIdJawab.getValue());
        s.setNilai((int) sldNilai.getValue());
        FXMLDocumentController.dtsoal.setModelSoal(s);
        if (editdata) {
            if (FXMLDocumentController.dtsoal.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtSoal.setEditable(true);
                klikbatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtsoal.validasi(s.getSoal_id()) >= 0) {
            System.out.println(FXMLDocumentController.dtsoal.validasi(s.getSoal_id()));
            if (FXMLDocumentController.dtsoal.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                klikbatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            sldIdSoal.requestFocus();
        }
    }

    @FXML
    private void klikbatal(ActionEvent event) {
    }

    @FXML
    private void klikkeluar(ActionEvent event) {
    }

}
