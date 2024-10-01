package app.empmanager.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/emp_manager";
    private static final String user = "postgres";
    private static final String password = "1360";
    private static Connection conn = null;

    private DatabaseConnection(){

    }

    private static Connection connect(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            System.out.println("DATABASE CONNECTION => "+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return conn;
    }
    public static Connection getConnection(){
        if (conn == null){
            connect();
            return conn;
        }else{
            return conn;
        }
    }

}
