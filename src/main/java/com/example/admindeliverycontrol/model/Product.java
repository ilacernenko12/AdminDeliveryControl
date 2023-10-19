package com.example.admindeliverycontrol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "goods")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double coast;
    private String productName;
    private String photoUrl;
    private String description;
    private int weight;
}
