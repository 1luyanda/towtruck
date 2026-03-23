package com.luyanda.towtruck.service;

import com.luyanda.towtruck.model.Request;
import com.luyanda.towtruck.model.Status;
import com.luyanda.towtruck.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository repository;

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public Request createRequest(Request request) {
        request.setStatus(Status.PENDING);
        return repository.save(request);
    }

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

    public Request acceptRequest(Long id) {
        Request request = repository.findById(id).orElseThrow();
        request.setStatus(Status.ACCEPTED);
        return repository.save(request);
    }

    public Request completeRequest(Long id) {
        Request request = repository.findById(id).orElseThrow();
        request.setStatus(Status.COMPLETED);
        return repository.save(request);
    }
}