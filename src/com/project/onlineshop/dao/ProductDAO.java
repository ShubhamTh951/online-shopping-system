package com.project.onlineshop.dao;

import com.project.onlineshop.product.Product;
import com.project.onlineshop.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
   public void saveProduct(Product product) throws Exception {
      String sql = "INSERT INTO products (name, description, price, stock, category) VALUES (?, ?, ?, ?, ?)";

      try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());
            stmt.setString(5, product.getCategory());
            
            stmt.executeUpdate();
            System.out.println("Product saved successfully.");
      } 
   }

   public boolean removeProduct(int productId) throws Exception {

      String sql = "DELETE FROM products WHERE product_id = ?";

      try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setInt(1, productId);

         return stmt.executeUpdate() > 0;
      }
   }

   public Product findById(int id) throws Exception {
      String sql = "SELECT * FROM products WHERE product_id = ?";

      try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
         
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getString("category")
                );
            }
      }
      return null;
   }

   public void updateStock(int productId, int newStock) throws Exception {
      String sql = "UPDATE products SET stock = ? WHERE product_id = ?";

      try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newStock);
            stmt.setInt(2, productId);

            stmt.executeUpdate();
        }
   }

}
