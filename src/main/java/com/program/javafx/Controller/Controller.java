package com.program.javafx.Controller;

import com.program.javafx.DatabaseConnection.DataBaseConnection;
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

    DataBaseConnection connection;

    @FXML
    private TableView<?> tvDeveloper;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    public TableColumn<?, ?> getColId() {
        return colId;
    }

    public TableColumn<?, ?> getColName() {
        return colName;
    }

    public TableColumn<?, ?> getColSpecialty() {
        return colSpecialty;
    }

    public TableColumn<?, ?> getColSalary() {
        return colSalary;
    }

    public TableColumn<?, ?> getColPhone() {
        return colPhone;
    }

    @FXML
    private TableColumn<?, ?> colSpecialty;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfPages;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnCleareField;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    public void initialize(URL location, ResourceBundle resource){


    }

}
