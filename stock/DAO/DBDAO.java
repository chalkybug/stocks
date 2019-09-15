/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import stock.BUS.DBConnect;

/**
 *
 * @author luong
 */
public class DBDAO {

    public void CreateTable() {
        try {
            Connection con = DBConnect.GetConnection();
            String sql1 = "CREATE TABLE `javadb`.`user` (`id` INT NOT NULL AUTO_INCREMENT,`Name` VARCHAR(45) NULL,`Balance` Double NULL,`Pass` VARCHAR(45) NULL, PRIMARY KEY (`id`));";
            String sql2 = "CREATE TABLE `javadb`.`stocks` (`id` INT NOT NULL AUTO_INCREMENT, `Name` VARCHAR(45) NULL,`Prices` INT NULL,PRIMARY KEY (`id`));";
            String sql3 = "CREATE TABLE `javadb`.`tradeorder` ( `id` INT NOT NULL AUTO_INCREMENT, `Name` VARCHAR(45) NULL,  `Quantity` INT NULL, `Prices` INT NULL, PRIMARY KEY (`id`));";
            if (con != null) {
                java.sql.Statement st = con.createStatement();
                st.execute(sql1);
                st.execute(sql2);
                st.execute(sql3);
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
