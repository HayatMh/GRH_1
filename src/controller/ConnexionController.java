package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.fxml.LoadListener;

import administrationModel.Login;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConnexionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField matricule;

    @FXML
    private JFXPasswordField motdp;

    @FXML
    private JFXButton buttonConnect;

    @FXML
    void Connect(ActionEvent event) throws IOException {
    	Login l=new Login();
    	int x=l.connexion(Integer.parseInt(matricule.getText()),Integer.parseInt(motdp.getText()));
    	switch(x) {
    	case 1:

    		///open Admin.FXML
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/view/Admin.fxml"));
    		Parent adminParent= loader.load();
    		Scene adminScene =new Scene(adminParent);
    		 Stage Adminwindow = new Stage();
    		 Adminwindow.setScene(adminScene);
    		 Adminwindow.show();
    		 
    		///Pass data to adminController
    		AdminController admincontroller= loader.getController();
    		admincontroller.initData(matricule.getText());
    		
            ///Close Connexion.FXML
    		Stage stg = (Stage) buttonConnect.getScene().getWindow();
    		stg.close();
    		break;
    	case 2:
    		
    		///open Employe.FXML
    		FXMLLoader Emploader = new FXMLLoader();
    		Emploader.setLocation(getClass().getResource("/view/Employe.fxml"));
    		Parent EmpParent= Emploader.load();
    		Scene EmpScene =new Scene(EmpParent);
    		 Stage Empwindow = new Stage();
    		 Empwindow.setScene(EmpScene);
    		 Empwindow.show();
    		
    		 
    		 /*
    		 
    		///Pass data to adminController
    		EmployeController empcontroller= Emploader.getController();
    		empcontroller.initData(Integer.parseInt(matricule.getText()));
    		
    		*/
    		
    		///close Connexion.FXML
    		 Stage stgEmp = (Stage) buttonConnect.getScene().getWindow();
    		 stgEmp.close();
    		break;
    	case 3:
    		System.out.println("mdp errone");
    		break;

    	}     
    }
 
    @FXML
    void initialize() {
    }
}
