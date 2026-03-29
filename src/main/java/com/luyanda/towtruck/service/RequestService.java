package com.luyanda.towtruck.service;

import com.luyanda.towtruck.model.Request;
import com.luyanda.towtruck.model.Status;
import com.luyanda.towtruck.model.Driver; // crucial this one
import com.luyanda.towtruck.repository.RequestRepository;
import com.luyanda.towtruck.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository repository;
    private final DriverRepository driverRepository;

    // ONLY ONE constructor
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
        Request request = repository.findById(requestId).orElseThrow();
        Driver driver = driverRepository.findById(driverId).orElseThrow();

        request.setStatus(Status.ACCEPTED);
        request.setDriver(driver);

        return repository.save(request);
    }

    public Request completeRequest(Long id) {
        Request request = repository.findById(id).orElseThrow();
        request.setStatus(Status.COMPLETED);
        return repository.save(request);
    }
}