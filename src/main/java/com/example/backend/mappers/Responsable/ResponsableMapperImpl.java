package com.example.backend.mappers.Responsable;

import com.example.backend.dtos.Responsable.ResponsableDTO;
import com.example.backend.entites.Responsable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ResponsableMapperImpl {
    public ResponsableDTO fromResponsable(Responsable responsable){
        ResponsableDTO responsableDTO = new ResponsableDTO();
        BeanUtils.copyProperties(responsable,responsableDTO);
        return  responsableDTO;
    }
    public Responsable fromResponsableDTO(ResponsableDTO responsableDTO ){
        Responsable responsable = new Responsable();
        BeanUtils.copyProperties(responsableDTO,responsable);
        return responsable;
    }
}