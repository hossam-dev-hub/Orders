package com.codwithhossam.progicuser.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codwithhossam.progicuser.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
