package com.program.javafx.Model.DAO;

import com.program.javafx.Controller.Controller;
import com.program.javafx.DatabaseConnection.DataBaseConnection;
import com.program.javafx.Model.Entities.Developer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.Statement;

public class DeveloperDAO {
    private DataBaseConnection connection;
    private Controller controller;

    public ObservableList<Developer> getDeveloperList(){
     ObservableList<Developer> developerList = FXCollections.observableArrayList();
     connection.getConnection();
     String query = "SELECT * FROM developers";
     Statement st;
     ResultSet rs;

     try {
         st = connection.getConnection().createStatement();
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
     }
     return developerList;
    }

    public void showDeveloper(){
        ObservableList<Developer> list = getDeveloperList();

        controller.getColId().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("id"));

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
        connection.getConnection();
        Statement st;
        try {
            st = connection.getConnection().createStatement();
            st.executeQuery(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
