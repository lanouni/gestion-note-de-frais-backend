package com.example.backend.dtos.Consultant;

import lombok.Data;

@Data
public class ConsultantInscriptionDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
}