package com.example.backend.mappers.Responsable;

import com.example.backend.dtos.Responsable.ResponsableInscriptionDTO;
import com.example.backend.entites.Responsable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ResponsableInscriptionMapperImpl {
    public ResponsableInscriptionDTO fromResponsable(Responsable responsable){
        ResponsableInscriptionDTO responsableDTO = new ResponsableInscriptionDTO();
        BeanUtils.copyProperties(responsable,responsableDTO);
        return  responsableDTO;
    }
    public Responsable fromResponsableDTO(ResponsableInscriptionDTO responsableDTO ){
        Responsable responsable = new Responsable();
        BeanUtils.copyProperties(responsableDTO,responsable);
        return responsable;
    }
}