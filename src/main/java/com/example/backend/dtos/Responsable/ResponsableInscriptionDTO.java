package com.example.backend.dtos.Responsable;

import lombok.Data;

@Data
public class ResponsableInscriptionDTO {
    private String nom;
    private String prenom;
    private String email;
    private String job;
    private String password;
}