package com.example.backend.dtos.NoteFrais;

import lombok.Data;

import java.util.Date;

@Data
public class NoteFraisDTO {
    private Long id;
    private Date DateFrais;
    private String Status;
    private String client;
    private String projet;
    private String typeIntervention;
    private String remarque;
}