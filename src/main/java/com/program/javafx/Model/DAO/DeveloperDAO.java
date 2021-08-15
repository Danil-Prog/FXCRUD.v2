package com.program.javafx.Model.DAO;

import com.program.javafx.Controller.Controller;
import com.program.javafx.DatabaseConnection.DataBaseConnection;
import com.program.javafx.Model.Entities.Developer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeveloperDAO {
    public DataBaseConnection connection = new DataBaseConnection();
    public static Controller controller = new Controller();

    public ObservableList<Developer> getDeveloperList(){
        ObservableList<Developer> developerList = FXCollections.observableArrayList();
        Connection conn = connection.getConnection();
        String query = "SELECT * FROM developers";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Developer developer;
            while (rs.next()){
                developer = new Developer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getInt("salary"),
                        rs.getInt("phone"));
                developerList.add(developer);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error 'Select from developers'");
        }
        return developerList;
    }

    public void showDeveloper(){
        ObservableList<Developer> list = getDeveloperList();

        controller.getColId().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("id"));
        controller.getColName().setCellValueFactory(new PropertyValueFactory<Developer, String>("name"));
        controller.getColSpecialty().setCellValueFactory(new PropertyValueFactory<Developer, String>("specialty"));
        controller.getColSalary().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("salary"));
        controller.getColPhone().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("phone"));

        controller.getTvDeveloper().setItems(list);
    }

    public void insertRecord(){

        String query = "INSERT INTO developers VALUES (" +
                controller.getColId().getText() + ",'" +
                controller.getColName().getText() + ",'" +
                controller.getColSpecialty().getText() + ",'" +
                controller.getColSalary().getText() + "," +
                controller.getColPhone().getText() + ")";
        executeQuery(query);
        showDeveloper();
    }

    private void executeQuery(String query){
        Connection conn = connection.getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}