package com.project.onlineshop.service;

import com.project.onlineshop.dao.ProductDAO;
import com.project.onlineshop.product.Product;

public class InventoryService {

    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) throws Exception {

        productDAO.saveProduct(product);
    }

    public boolean removeProduct(int productId) throws Exception {
        return productDAO.removeProduct(productId);
    }

    public Product findProductById(int id) throws Exception {

        return productDAO.findById(id);
    }

    public void updateStock(int productId, int newStock) throws Exception {

        productDAO.updateStock(productId, newStock);
    }
}