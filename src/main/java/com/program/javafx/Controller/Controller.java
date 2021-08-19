package com.program.javafx.Controller;

import com.program.javafx.Model.DAO.DeveloperDAO;
import com.program.javafx.Model.Entities.Developer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private DeveloperDAO developerDAO;

    public Controller(){
        this.developerDAO = new DeveloperDAO(this);
    }

    //tv - table view (таблица с колонками)
    @FXML
    private TableView<Developer> tvDeveloper;

    public TableView<Developer> getTvDeveloper() {
        return tvDeveloper;
    }


    //колонки из таблицы (colId, colName, colSpecialty, colSalary, colPhone)
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

        public TextField getTfId() {
            return tfId;
        }

        public TextField getTfName() {
            return tfName;
        }

        public TextField getTfSpecialty() {
            return tfSpecialty;
        }

        public TextField getTfSalary() {
            return tfSalary;
        }

        public TextField getTfPhone() {
            return tfPhone;
        }

    //кнопки(добавить, обновить, удалить, очиститьПоле)
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
        if (event.getSource() == btnInsert){
            developerDAO.insertRecord();
        }else if (event.getSource() == btnDelete){
            developerDAO.deleteRecord();
        }else if (event.getSource() == btnUpdate){
            developerDAO.updateRecord();
        }

    }
    //этот метод отображает данные в таблицу
    @Override
    public void initialize(URL location, ResourceBundle resource){
        developerDAO.showDeveloper();

    }

}