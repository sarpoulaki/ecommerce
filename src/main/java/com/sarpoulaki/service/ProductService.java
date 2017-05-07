package com.sarpoulaki.service;

import com.sarpoulaki.model.Product;

import java.util.List;

/**
 * Created by admin on 5/6/2017.
 */
public interface ProductService {

    public void addProduct(Product p);

    public void updateProduct(Product p);

    public List<Product> listProducts();

    public Product getProductById(int id);

    public void removeProduct(int id);

}
