package com.example.backend.dtos.NoteFrais;

import lombok.Data;

import java.util.Date;

@Data
public class NewNoteFraisDTO {
    private Long Consultantid;
    private Date DateFrais;
    private String Status;
    private String client;
    private String projet;
    private String typeIntervention;
    private String remarque;
}