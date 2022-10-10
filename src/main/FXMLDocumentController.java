/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package main;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.*;

/**
 *
 * @author LENOVO
 */
public class FXMLDocumentController implements Initializable {
    public static DBUser dtuser = new DBUser();
    public static DBSoal dtsoal = new DBSoal();
    public static DBTerjawab dtterjawab = new DBTerjawab();
    public static DBScore dtscore = new DBScore();
    private Label label;
    @FXML
    private MenuItem displayUserKlik;
    @FXML
    private MenuItem displaySoalklik;
    @FXML
    private MenuItem inputSoalklik;
    @FXML
    private MenuItem displayTerjawabKlik;
    @FXML
    private MenuItem displayScoreKlik;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void displayUserKlik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplayUser.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void inputUserKlik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputUser.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void displaySoalklik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplaySoal.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void inputSoalklik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputSoal.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void displayTerjawabKlik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplayTerjawab.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void displayScoreKlik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDisplayScore.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    
}
