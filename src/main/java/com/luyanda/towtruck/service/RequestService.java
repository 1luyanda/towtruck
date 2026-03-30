package com.luyanda.towtruck.service;

import com.luyanda.towtruck.model.Request;
import com.luyanda.towtruck.model.Status;
import com.luyanda.towtruck.model.Driver;
import com.luyanda.towtruck.repository.RequestRepository;
import com.luyanda.towtruck.repository.DriverRepository;
import com.luyanda.towtruck.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository repository;
    private final DriverRepository driverRepository;

    public RequestService(RequestRepository repository, DriverRepository driverRepository) {
        this.repository = repository;
        this.driverRepository = driverRepository;
    }

    public Request createRequest(Request request) {
        request.setStatus(Status.PENDING);
        return repository.save(request);
    }

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

    public Request acceptRequest(Long requestId, Long driverId) {
        Request request = repository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + requestId));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + driverId));

        if (request.getStatus() != Status.PENDING) {
            throw new IllegalStateException("Only PENDING requests can be accepted");
        }

        request.setStatus(Status.ACCEPTED);
        request.setDriver(driver);
        return repository.save(request);
    }

    public Request completeRequest(Long id) {
        Request request = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + id));

        if (request.getStatus() != Status.ACCEPTED) {
            throw new IllegalStateException("Only ACCEPTED requests can be completed");
        }

        request.setStatus(Status.COMPLETED);
        return repository.save(request);
    }
}