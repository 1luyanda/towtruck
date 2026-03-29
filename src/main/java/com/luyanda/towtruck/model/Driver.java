package com.luyanda.towtruck.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Driver{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String phone;
    private String location;

}