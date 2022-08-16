package edu.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.entities.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

}
