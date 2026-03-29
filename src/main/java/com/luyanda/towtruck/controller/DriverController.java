package com.luyanda.towtruck.controller;

import com.luyanda.towtruck.model.Driver;
import com.luyanda.towtruck.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return service.createDriver(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }
}