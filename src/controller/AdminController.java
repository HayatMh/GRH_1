package controller;

import java.net.URL;
import java.util.ResourceBundle;

import administrationModel.Administrateur;
import administrationModel.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField acceuil_occupation;

    @FXML
    private TextField acceuil_nom;

    @FXML
    private TextField acceuil_dapartement;

    @FXML
    private TextField acceuil_adresse;

    @FXML
    private TextField acceuil_prenom;

    @FXML
    private TextField acceuil_matricule;

    @FXML
    private TextField acceuil_mail;

    @FXML
    private TextField acceuil_datenaissance;

    @FXML
    private TextField acceuil_salaire;

    @FXML
    private TextField acceuil_rstconge;

    @FXML
    private Button empl_recherchebutton;

    @FXML
    private TextField empl_recherche;

    @FXML
    private TableView<?> empltab;

    @FXML
    private TableColumn<?, ?> empltab_matricule;

    @FXML
    private TableColumn<?, ?> empltab_nom;

    @FXML
    private TableColumn<?, ?> empltab_prenom;

    @FXML
    private TableColumn<?, ?> empltab_departement;

    @FXML
    private TableView<?> congetab;

    @FXML
    private TableColumn<?, ?> congetab_matricule;

    @FXML
    private TableColumn<?, ?> congetab_nom;

    @FXML
    private TableColumn<?, ?> congetab_prenom;

    @FXML
    private TableColumn<?, ?> congetab_departement;

    @FXML
    private TableColumn<?, ?> congetab_etat;

    @FXML
    private TableView<?> fdptab;

    @FXML
    private TableColumn<?, ?> fdptab_matricule;

    @FXML
    private TableColumn<?, ?> fdptab_nom;

    @FXML
    private TableColumn<?, ?> fdptab_prenom;

    @FXML
    private TableColumn<?, ?> fdptab_departement;

    @FXML
    private TableColumn<?, ?> fdptab_etat;

    @FXML
    private TableView<?> attestationtab;

    @FXML
    private TableColumn<?, ?> attestationtab_matricule;

    @FXML
    private TableColumn<?, ?> attestationtab_nom;

    @FXML
    private TableColumn<?, ?> attestationtab_prenom;

    @FXML
    private TableColumn<?, ?> attestationtab_departement;

    @FXML
    private TableColumn<?, ?> attestationtab_etat;

    @FXML
    void ajoutEmpl(ActionEvent event) {

    }

    @FXML
    void rechercheEmpl(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
    
    void initData(String x) {
    	Employee emp=new Employee();
    	Administrateur adm=new Administrateur();
    	emp=adm.retournerEmp(Integer.parseInt(x));
    	acceuil_matricule.setText(Integer.toString(emp.getMatricule()));
    	acceuil_nom.setText(emp.getNom());
    	acceuil_prenom.setText(emp.getPrenom());
    	acceuil_adresse.setText(emp.getAdresse());
    	acceuil_occupation.setText(emp.getOccupation());
    	acceuil_dapartement.setText(emp.getDepartement());
    	acceuil_mail.setText(emp.getEmail());
    	acceuil_datenaissance.setText(emp.getDateNaiss());
    	acceuil_salaire.setText(Double.toString(emp.getSalaire()));
    	acceuil_rstconge.setText(Integer.toString(emp.getResteConge()));
    }
}
