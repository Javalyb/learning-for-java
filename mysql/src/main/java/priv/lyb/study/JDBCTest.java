package priv.lyb.study;

import java.sql.*;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 13:08 2021/02/26
 */
public class JDBCTest {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
                    PreparedStatement preparedStatement = connection.prepareStatement("select count(1) count from db");
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                resultSet.next();
                System.out.println(resultSet.getInt("count"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
