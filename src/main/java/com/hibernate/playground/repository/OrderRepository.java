package com.hibernate.playground.repository;

import com.hibernate.playground.domain.manytomany.unidirectional.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
