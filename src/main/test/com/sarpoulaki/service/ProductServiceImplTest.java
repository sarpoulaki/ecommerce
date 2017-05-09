package com.sarpoulaki.service;

import com.sarpoulaki.model.Product;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by admin on 5/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/root-context.xml"})
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;
    @Before
    public void setUp() throws Exception {
    }

    @Ignore
    @Test
    public void addProduct() throws Exception {
        Product product = new Product();
        product.setName("Test");
        productService.addProduct(product);
        assertNotNull(product.getId());
    }

}