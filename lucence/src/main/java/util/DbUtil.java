package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String url="jdbc:mysql://localhost:3306/userdb?useUnicode=true&characterEncoding=utf8";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static Connection gerConnection(){
        try {
          return   DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
