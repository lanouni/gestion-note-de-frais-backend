package com.example.backend.mappers.Consultant;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.entites.Consultant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConsultantMapperImpl {

    public ConsultantDTO fromConsultant(Consultant consultant){
        ConsultantDTO consultantDTO = new ConsultantDTO();
        BeanUtils.copyProperties(consultant,consultantDTO);
  /*      consultantDTO.setEmail(consultant.getEmail());
        consultantDTO.setId(consultant.getId());
        consultantDTO.setNom(consultant.getNom());
        consultantDTO.setPrenom(consultant.getPrenom());*/
        return consultantDTO;
    }
    public Consultant fromConsultantDTO(ConsultantDTO consultantDTO){
        Consultant consultant = new Consultant();
        consultant.setEmail(consultantDTO.getEmail());
        consultant.setId(consultantDTO.getId());
        consultant.setNom(consultantDTO.getNom());
        consultant.setPrenom(consultantDTO.getPrenom());
        return consultant;
    }
}