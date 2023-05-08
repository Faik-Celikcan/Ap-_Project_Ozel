package stepdefinitions.us06;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

public class US06_3_DataBaseKontrol_StepDef {

    ResultSet resultSet;
    Statement statement;
    Connection connection;
    @Given("Data Baseden baglanti kurma")
    public void data_baseden_baglanti_kurma() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:8080/school_management", "select_user", "43w5ijfso");

        statement=connection.createStatement();
        resultSet=statement.executeQuery("SELECT * FROM teacher WHERE id = 35");

    }
    @Then("Vice Dean Hesabi Kontrolu")
    public void vice_dean_hesabi_kontrolu() {

    }
}
