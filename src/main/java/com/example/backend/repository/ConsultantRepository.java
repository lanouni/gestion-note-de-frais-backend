package com.example.backend.repository;

import com.example.backend.entites.Consultant;
import com.example.backend.entites.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultantRepository extends JpaRepository<Consultant,Long> {
    Consultant findByEmailAndPassword(String email , String password);
    Consultant findByEmail(String email);


    List<Consultant> findByResponsableId(Long id);
}
