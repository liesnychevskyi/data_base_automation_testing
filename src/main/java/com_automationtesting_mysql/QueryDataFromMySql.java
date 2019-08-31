package com_automationtesting_mysql;

import java.sql.*;

public class QueryDataFromMySql
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        //---------------------------------------------------------------------------------------------------------//
        //Mysql@localhost:3306
        Connection connection = null;  // connection class instance
        String dbUrl = "jdbc:mysql://localhost/automationtesting?useSSL=true"; // URL db MySql by default
        String driver = "com.mysql.cj.jdbc.Driver"; // driver to connect to db
        String userName = "root";                   // username of db
        String password = "2728torikpes2728";       // password of db

        Class.forName(driver).newInstance(); // connection between IDEA and DataBase
        connection = DriverManager.getConnection(dbUrl, userName, password); // we pass the private data of db

        System.out.println("Connection established successfully to : " + connection);
        System.out.println("========================================================================================");

        Statement st = connection.createStatement(); // Statement obj, it use for executing queries
        ResultSet rs = st.executeQuery("select * from credentials");

        while (rs.next()) // printing all the data from the db
        {
            System.out.println("User names: " + rs.getString("UserName") + " -- "+"Password: " + rs.getString("Password")+" -- "+"Date created: " + rs.getString("DataCreated")+" -- "+"No of attempts: " + rs.getString("NoOfAttempts")+" -- "+"Result: " + rs.getString("Result"));
        }
        rs.close();
    }
}
