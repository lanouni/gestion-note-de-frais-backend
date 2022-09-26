package com.example.backend.service.NoteFrais;

import com.example.backend.dtos.NoteFrais.NewNoteFraisDTO;
import com.example.backend.dtos.NoteFrais.NoteFraisDTO;
import com.example.backend.exception.ConsultantNotFoundException;

import java.util.List;

public interface INoteFraisService {
    List<NoteFraisDTO> lisNoteFrais(long Id);
    NoteFraisDTO getNoteFrais(long id);
    NewNoteFraisDTO saveNote(long consultantId,NewNoteFraisDTO noteFraisDTO) throws ConsultantNotFoundException;

    void deleteNoteFrais(Long id);
}
