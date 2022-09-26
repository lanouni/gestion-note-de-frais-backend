package com.example.backend.dtos.Depense;

import com.example.backend.entites.NoteFrais;
import lombok.Data;


import java.util.Date;

@Data
public class DepenseDTO {
    private Long id;
    private Date DateFrais;
    private String description;
    private double taxi;
    private double Hotel;
    private double repas;
    private double hebergement;
}