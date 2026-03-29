package com.luyanda.towtruck.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated ID

    private String customerName; // Name of the person requesting a tow
    private String location;     // Location of the tow request

    @Enumerated(EnumType.STRING)
    private Status status;       // Status: PENDING, ACCEPTED, COMPLETED

    @ ManyToOne
    @JoinColumn(name ="driver_id")
    private Driver driver;

}