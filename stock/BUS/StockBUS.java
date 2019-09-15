package stock.BUS;

import stock.DTO.TradeOrder;
import stock.DTO.User;
import stock.DTO.Stocks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import stock.DAO.DBDAO;

public class StockBUS {

    public static void main(String[] args) {
      DBDAO db = new DBDAO();
      db.CreateTable();
    }
}
