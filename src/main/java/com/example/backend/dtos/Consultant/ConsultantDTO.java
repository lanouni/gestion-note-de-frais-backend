package com.example.backend.dtos.Consultant;

import lombok.Data;

@Data
public class ConsultantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}