package com.example.backend.service.Responsable;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Responsable.ResponsableDTO;
import com.example.backend.dtos.Responsable.ResponsableInscriptionDTO;

import java.util.List;

public interface IResponsableService {
    List<ResponsableDTO> listResponsables();
    ResponsableDTO getResponsable(long id);
    ResponsableInscriptionDTO saveResponsable(ResponsableInscriptionDTO responsable);

    void deleteResponsable(Long id);

    List<ConsultantDTO> listConsultant(Long id);
}
