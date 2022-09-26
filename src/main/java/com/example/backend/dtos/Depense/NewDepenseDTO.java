package com.example.backend.dtos.Depense;

import lombok.Data;

import java.util.Date;

@Data
public class NewDepenseDTO {
    private Date DateFrais;
    private String description;
    private double taxi;
    private double Hotel;
    private double repas;
    private double hebergement;
    private long NoteFraisId;
}