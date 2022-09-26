package com.example.backend.repository;

import com.example.backend.entites.NoteFrais;
import com.example.backend.entites.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteFraisRepository extends JpaRepository<NoteFrais,Long> {

    List<NoteFrais> findByConsultantId(long id);
}
