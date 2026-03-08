package com.project.onlineshop.dao;

import com.project.onlineshop.order.OrderStatus;
import com.project.onlineshop.util.DBConnection;

import java.sql.*;
import java.util.Map;

public class OrderDAO {

    public int createOrder(int userId, double totalAmount, Map<Integer, Integer> productMap) throws Exception {
        Connection conn = DBConnection.getConnection();

        try {
            conn.setAutoCommit(false);

            String orderSql = "INSERT INTO orders(user_id, total_amount, order_status) VALUES (?, ?, ?) RETURNING order_id";
            
            PreparedStatement orderStmt = conn.prepareStatement(orderSql);
            orderStmt.setInt(1, userId);
            orderStmt.setDouble(2, totalAmount);
            orderStmt.setString(3, OrderStatus.PAID.name());

            ResultSet rs = orderStmt.executeQuery();
            rs.next();
            int orderId = rs.getInt(1);

            String itemSql = "INSERT INTO order_items(order_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement itemStmt = conn.prepareStatement(itemSql);

            for (var entry : productMap.entrySet()) {
                itemStmt.setInt(1, orderId);
                itemStmt.setInt(2, entry.getKey());
                itemStmt.setInt(3, entry.getValue());
                itemStmt.executeUpdate();
            }

            conn.commit();
            return orderId;

        } catch (Exception e) {
            conn.rollback();
            throw e;
        }
        finally {
            conn.close();
        }
    }

    public void displayAllOrders() throws Exception {

    String sql = "SELECT * FROM orders";

    try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                    "Order ID: " + rs.getInt("order_id") +
                    " | User ID: " + rs.getInt("user_id") +
                    " | Amount: " + rs.getDouble("total_amount") +
                    " | Status: " + rs.getString("order_status")
                );
            }
        }
    }
}
