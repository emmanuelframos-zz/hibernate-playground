package com.test;

import com.hibernate.playground.domain.manytoone.Brand;
import com.hibernate.playground.domain.manytoone.Product;
import com.hibernate.playground.service.ProductService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManyToOneTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(ManyToOneTest.class);

    @Autowired
    private ProductService productService;

    @Test
    public void saveProductsForSameBrand(){

        /** Create Product One **/
        Brand brand = new Brand("Brand One");

        Product product = new Product("Product One", brand);

        product = productService.save(product);

        /** Fetch Brand **/
        brand = productService.findOne(product.getId()).getBrand();

        /** Create Product Two **/
        Product newProduct = new Product("Product Two", brand);

        productService.save(newProduct);

        /** Listing Products **/
        List<Product> products = productService.findAll();

        products.stream().forEach(p -> logger.info(p.toString()));

    }
}