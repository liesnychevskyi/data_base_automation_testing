package com_automationtesting_mysql;

import java.sql.*;

public class InsertDataToMySql
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        //---------------------------------------------------------------------------------------------------------// Connection to the DB
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
        //==========================================================================================================// Executing the query
        //Statement st = connection.createStatement(); // Statement obj, it use for executing queries
        //ResultSet rs = st.executeQuery("select * from credentials");
        //==========================================================================================================// Insert the data to DB
        //-------------// Insert data to DB
        PreparedStatement ps = connection.prepareStatement("INSERT into credentials(UserName,Password,DataCreated,NoOfAttempts,Result)VALUES('DemoUser','demo@password','2015-07-27','1000','PASS')");
        ps.executeUpdate();
        connection.close();

        QueryDataFromMySql print = new QueryDataFromMySql();

    }

}
