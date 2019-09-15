/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import stock.BUS.DBConnect;
import stock.DTO.User;

/**
 *
 * @author luong
 */
public class UserDAO {

    public int Add(User user) {
        Connection connection = DBConnect.GetConnection();
        String sql = "insert into User(id,name,balance,pass) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDouble(3, user.getBalance());
            preparedStatement.setString(4, user.getPass());
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                System.out.println("them thanh cong");
            }
            connection.close();
            return 1;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public int Update(User user) {
        Connection connection = DBConnect.GetConnection();
        String sql = "Update User set name=?,balance=?,pass=? where id=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.setDouble(2, user.getBalance());
            preparedStatement.setString(3, user.getPass());
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                System.out.println("Cap nhat thanh cong");
            }
            connection.close();
            return 1;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return 0;
    }

    public int Delete(int id) {
        Connection connection = DBConnect.GetConnection();
        String sql = "delete from User where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                System.out.println("Xoa thanh Cong");
            }
            connection.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<User> All() {
        ArrayList<User> lstUser = new ArrayList<>();
        Connection connection = DBConnect.GetConnection();
        String sql = "select* from User";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);

            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"), rs.getString("pass"));
                lstUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstUser;
    }

    public User GetUserByID(int id) {
        Connection connection = DBConnect.GetConnection();
        String sql = "select * from User where id=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"), rs.getString("pass"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
