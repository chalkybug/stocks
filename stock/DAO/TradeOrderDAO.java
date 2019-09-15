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
import stock.DTO.TradeOrder;

/**
 *
 * @author luong
 */
public class TradeOrderDAO {

    public int Add(TradeOrder tradeOrder) {
        Connection connection = DBConnect.GetConnection();
        String sql = "insert into TradeOrder(name,prices,quantity,id) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tradeOrder.getName());
            preparedStatement.setInt(2, tradeOrder.getPrices());
            preparedStatement.setInt(3, tradeOrder.getQuantity());
            preparedStatement.setInt(4, 0);
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

    public int Update(TradeOrder tradeOrder) {
        Connection connection = DBConnect.GetConnection();
        String sql = "Update TradeOrder set prices=?,quantity=?,name=? where id=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tradeOrder.getPrices());
            preparedStatement.setInt(2, tradeOrder.getQuantity());
            preparedStatement.setString(3, tradeOrder.getName());
            preparedStatement.setInt(4, tradeOrder.getId());
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
        String sql = "delete from TradeOrder where id=?";
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

    public ArrayList<TradeOrder> All() {
        ArrayList<TradeOrder> lstTradeOrder = new ArrayList<>();
        Connection connection = DBConnect.GetConnection();
        String sql = "select * from TradeOrder";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);

            while (rs.next()) {
                TradeOrder tradeOrder = new TradeOrder(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getInt("prices"));
                lstTradeOrder.add(tradeOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstTradeOrder;
    }

    public TradeOrder GetTradeOrderByID(int id) {
        Connection connection = DBConnect.GetConnection();
        String sql = "select * from TradeOrder where id=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()) {
                TradeOrder tradeOrder = new TradeOrder(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getInt("prices"));
                return tradeOrder;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
