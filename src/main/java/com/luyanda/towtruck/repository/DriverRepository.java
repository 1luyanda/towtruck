package com.luyanda.towtruck.repository;

import com.luyanda.towtruck.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}