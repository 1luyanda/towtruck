package com.luyanda.towtruck.repository;

import com.luyanda.towtruck.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA provides CRUD operations automatically
public interface RequestRepository extends JpaRepository<Request, Long> {
}