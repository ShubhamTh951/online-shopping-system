package com.project.onlineshop.dao;

import com.project.onlineshop.user.Customer;
import com.project.onlineshop.util.DBConnection;

import java.beans.Customizer;
import java.sql.*;

public class UserDAO {
    public Customer findCustomerByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ? AND role = 'CUSTOMER'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return new Customer(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getDouble("balance")
                    );
                }
             }
             return null;
    }

    public void updateBalance(int userId, double newBalance) throws Exception {

        String sql = "UPDATE users SET balance = ? WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newBalance);
            stmt.setInt(2, userId);

            stmt.executeUpdate();
        }
    }
}
