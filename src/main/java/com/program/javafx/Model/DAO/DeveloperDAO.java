package com.program.javafx.Model.DAO;

import com.program.javafx.Controller.Controller;
import com.program.javafx.DatabaseConnection.DataBaseConnection;
import com.program.javafx.Model.Entities.Developer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Класс управления базой данных
public class DeveloperDAO {

    private Controller controller;

    public DeveloperDAO(Controller controller){
        this.controller = controller;
    }
    public DataBaseConnection connection = new DataBaseConnection();

    //добавления записей из таблицы в список
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

    //отобразить данные таблицы
    public void showDeveloper(){
        ObservableList<Developer> list = getDeveloperList();

        controller.getColId().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("id"));
        controller.getColName().setCellValueFactory(new PropertyValueFactory<Developer, String>("name"));
        controller.getColSpecialty().setCellValueFactory(new PropertyValueFactory<Developer, String>("specialty"));
        controller.getColSalary().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("salary"));
        controller.getColPhone().setCellValueFactory(new PropertyValueFactory<Developer, Integer>("phone"));

        controller.getTvDeveloper().setItems(list);
    }

    //вставить запись в таблицу и отобразить данные
    public void insertRecord(){
        try {
            String query = "INSERT INTO developers VALUES (" +
                    controller.getTfId().getText() + ",'" +
                    controller.getTfName().getText() + "','" +
                    controller.getTfSpecialty().getText() + "'," +
                    controller.getTfSalary().getText() + "," +
                    controller.getTfPhone().getText() + ")";
            executeQuery(query);
            System.out.println("Запись успешно добавлена!");
            showDeveloper();
        }catch (Exception ex){
            System.out.println("Синтаксическая ошибка SQL запроса " + ex);
        }
    }

    //удалить запись
    public void deleteRecord(){
        String query = "DELETE FROM developers WHERE id = " + controller.getTfId().getText() + "";
        executeQuery(query);
        showDeveloper();
    }

    //обновить запись
    public void updateRecord(){
        String query = "UPDATE developers SET name = '" +
                controller.getTfName().getText() + "', specialty = '" +
                controller.getTfSpecialty().getText() + "', salary = " +
                controller.getTfSalary().getText() + ", phone = " +
                controller.getTfPhone().getText() +
                " WHERE id = " + controller.getTfId().getText() + "";
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