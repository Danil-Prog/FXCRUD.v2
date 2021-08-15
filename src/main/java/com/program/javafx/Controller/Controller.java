package com.program.javafx.Controller;

import com.program.javafx.DatabaseConnection.DataBaseConnection;
import com.program.javafx.Model.DAO.DeveloperDAO;
import com.program.javafx.Model.Entities.Developer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static DeveloperDAO developerDAO = new DeveloperDAO();

    @FXML
    private TableView<Developer> tvDeveloper;

    public TableView<Developer> getTvDeveloper() {
        return tvDeveloper;
    }

    @FXML
    private TableColumn<Developer, Integer> colId;

    @FXML
    private TableColumn<Developer, String> colName;

    @FXML
    private TableColumn<Developer, String> colSpecialty;

    @FXML
    private TableColumn<Developer, Integer> colSalary;

    @FXML
    private TableColumn<Developer, Integer> colPhone;
        @FXML
        public TableColumn<Developer, Integer> getColId() {
            return colId;
        }
        @FXML
        public TableColumn<Developer, String> getColName() {
            return colName;
        }
        @FXML
        public TableColumn<Developer, String> getColSpecialty() {
            return colSpecialty;
        }
        @FXML
        public TableColumn<Developer, Integer> getColSalary() {
            return colSalary;
        }
        @FXML
        public TableColumn<Developer, Integer> getColPhone() {
            return colPhone;
        }

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSpecialty;

    @FXML
    private TextField tfSalary;

    @FXML
    private TextField tfPhone;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnClearField;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resource){
        developerDAO.showDeveloper();

    }

}