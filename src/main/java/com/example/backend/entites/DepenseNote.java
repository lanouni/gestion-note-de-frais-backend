package com.example.backend.entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepenseNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateFrais;
    private String description;
    private double taxi;
    private double Hotel;
    private double repas;
    private double hebergement;
    @ManyToOne
    private NoteFrais noteFrais;

}