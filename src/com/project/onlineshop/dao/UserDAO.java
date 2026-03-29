package com.project.onlineshop.dao;

import com.project.onlineshop.user.Customer;
import com.project.onlineshop.util.DBConnection;

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

    public Customer saveCustomer(Customer customer) throws Exception {

        String sql = "INSERT INTO users(name, email, password, phone, address, balance, role) VALUES (?, ?, ?, ?, ?, ?, 'CUSTOMER') RETURNING user_id";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPassword());
            stmt.setString(4, customer.getPhone());
            stmt.setString(5, customer.getAddress());
            stmt.setDouble(6, customer.getBalance());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);

                return new Customer(
                        id,
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPassword(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getBalance()
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
