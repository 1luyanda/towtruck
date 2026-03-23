package com.luyanda.towtruck.controller;

import com.luyanda.towtruck.model.Request;
import com.luyanda.towtruck.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RequestService service;

    public RequestController(RequestService service) {
        this.service = service;
    }

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return service.createRequest(request);
    }

    @GetMapping
    public List<Request> getRequests() {
        return service.getAllRequests();
    }

    @PostMapping("/{id}/accept")
    public Request acceptRequest(@PathVariable Long id) {
        return service.acceptRequest(id);
    }

    @PostMapping("/{id}/complete")
    public Request completeRequest(@PathVariable Long id) {
        return service.completeRequest(id);
    }
}