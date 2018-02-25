package com.test;

import com.hibernate.playground.Application;
import com.hibernate.playground.domain.manytoone.Brand;
import com.hibernate.playground.domain.manytoone.Product;
import com.hibernate.playground.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Transactional
public class ManyToOneTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProductsForSameBrand(){

        /** Create Product One **/
        Brand brand = new Brand("Dummy Brand One");

        Product product = new Product("Dummy Product One", brand);

        product = productRepository.save(product);

        /** Fetch Brand **/
        brand = productRepository.findOne(product.getId()).getBrand();

        /** Create Product Two **/
        Product newProduct = new Product("Dummy Product Two", brand);

        productRepository.save(newProduct);

        /** Listing Products **/
        List<Product> products = productRepository.findAll();

        products.stream().forEach(System.out::println);

    }
}