package com.tap.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap.www.Entity.customerEntity;

public interface customerRepository extends JpaRepository<customerEntity,Long>{

}
