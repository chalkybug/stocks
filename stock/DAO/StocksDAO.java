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
import stock.DTO.Stocks;
import stock.DTO.User;

/**
 *
 * @author luong
 */
public class StocksDAO {

    public int Add(Stocks user) {
        Connection connection = DBConnect.GetConnection();
        String sql = "insert into Stocks(id,prices,name) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, user.getPrices());
            preparedStatement.setString(3, user.getName());
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

    public int Update(Stocks user) {
        Connection connection = DBConnect.GetConnection();
        String sql = "Update Stocks set name=?, prices=? where id=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getPrices());
            preparedStatement.setInt(3, user.getId());
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
        String sql = "delete from Stocks where id=?";
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

    public ArrayList<Stocks> All() {
        ArrayList<Stocks> lstStocks = new ArrayList<>();
        Connection connection = DBConnect.GetConnection();
        String sql = "select* from Stocks ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);

            while (rs.next()) {
                Stocks user = new Stocks(rs.getInt("id"), rs.getString("name"), rs.getInt("prices"));
                lstStocks.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstStocks;
    }

    public Stocks GetStocksrByID(int id) {
        Connection connection = DBConnect.GetConnection();
        String sql = "select * from Stocks where name=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()) {
                Stocks stocks = new Stocks(rs.getInt("id"), rs.getString("name"), rs.getInt("prices"));
                return stocks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
