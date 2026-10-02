package com.tap.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap.www.Entity.bookingEntity;

public interface bookingRepository extends JpaRepository<bookingEntity,Long> {
	

}
