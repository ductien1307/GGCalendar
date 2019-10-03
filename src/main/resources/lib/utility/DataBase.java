package lib.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=TSCOHR;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123";

    public ResultSet get_data(String sql){
        ResultSet rs = null;
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return rs;
    }

    public static Connection getConnection(String dbURL, String userName,String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (Exception ex) {
            System.out.println("connect DB failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
