package com.hibernate.playground.repository;

import com.hibernate.playground.domain.manytoone.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> { }
