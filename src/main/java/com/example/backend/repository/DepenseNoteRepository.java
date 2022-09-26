package com.example.backend.repository;

import com.example.backend.entites.DepenseNote;
import com.example.backend.entites.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepenseNoteRepository extends JpaRepository<DepenseNote,Long> {

    List<DepenseNote> findByNoteFraisId(long id);
}
