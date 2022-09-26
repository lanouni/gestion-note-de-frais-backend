package com.example.backend.mappers.Consultant;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Consultant.ConsultantInscriptionDTO;
import com.example.backend.entites.Consultant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConsultantInscriptionMapperImpl {

    public ConsultantInscriptionDTO fromConsultant(Consultant consultant){
        ConsultantInscriptionDTO consultantDTO = new ConsultantInscriptionDTO();
        BeanUtils.copyProperties(consultant,consultantDTO);

        return consultantDTO;
    }
    public Consultant fromConsultantDTO(ConsultantInscriptionDTO consultantDTO){
        Consultant consultant = new Consultant();
        BeanUtils.copyProperties(consultantDTO,consultant);
        return consultant;
    }
}