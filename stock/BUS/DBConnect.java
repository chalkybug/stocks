/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.BUS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luong
 */
public class DBConnect {
    public static Connection GetConnection (){
     final String url = "jdbc:mysql://localhost:3306/javadb?characterEncoding=utf8";
        final String user = "luong";
        final String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
