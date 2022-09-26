package com.example.backend.dtos.Responsable;

import lombok.Data;

@Data
public class ResponsableDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String job;
    private String password;
}