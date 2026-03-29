package com.luyanda.towtruck.service;

import com.luyanda.towtruck.model.Driver;
import com.luyanda.towtruck.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver createDriver(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }
}