package com.example.backend.repository;

import com.example.backend.entites.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableRepository extends JpaRepository<Responsable,Long> {
    Responsable findByEmailAndPassword(String email,String password);
}
