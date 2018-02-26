package com.hibernate.playground.service;

import com.hibernate.playground.domain.manytoone.Product;
import com.hibernate.playground.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Product findOne(Long id){
        return productRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }

}