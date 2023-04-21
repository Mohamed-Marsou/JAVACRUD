package ma.mtm.DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static String url = "jdbc:mysql://localhost:3306/studentmanagement";
    private static String username ="root";
    private static String password ="Mtm2022!4L";
    static Connection conn=null;
    private static void connect(){
        System.out.println("Connecting to Database .....");
        try {
            // register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //opening a connection
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected successfully");
        }  catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        if(conn==null){
            connect();
        }
        return conn;
    }
}
