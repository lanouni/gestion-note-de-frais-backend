package com.example.backend.service.Consultant;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Consultant.ConsultantInscriptionDTO;
import com.example.backend.exception.ConsultantNotFoundException;

import java.util.List;

public interface IConsultantService {

    List<ConsultantDTO> listConsultants();
    ConsultantDTO getConsultant(Long id) throws ConsultantNotFoundException;



    ConsultantDTO getConsultantbyEmail(String email) throws ConsultantNotFoundException;

    ConsultantInscriptionDTO saveConsultanta(ConsultantInscriptionDTO inscriptionDTO);

    void deleteConsultant(Long Id);
}
