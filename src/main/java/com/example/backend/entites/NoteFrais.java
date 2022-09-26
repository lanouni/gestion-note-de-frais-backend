package com.example.backend.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteFrais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateFrais;
    //private int nombreDeDepense;
   // private double montant;
    private String Status;
    private String client;
    private String projet;
    private String typeIntervention;
    @ManyToOne
    private Consultant consultant;
    @OneToMany(mappedBy = "noteFrais" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepenseNote> depenseNotes;
    private String remarque;
}