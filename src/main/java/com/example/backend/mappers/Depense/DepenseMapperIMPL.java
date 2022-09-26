package com.example.backend.mappers.Depense;

import com.example.backend.dtos.Depense.DepenseDTO;
import com.example.backend.entites.DepenseNote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DepenseMapperIMPL {

    public DepenseDTO fromDepense(DepenseNote  depenseNote){
        DepenseDTO depenseDTO= new DepenseDTO();
        BeanUtils.copyProperties(depenseNote,depenseDTO);
        return depenseDTO;
    }

    public DepenseNote fromDepenseDTO(DepenseDTO  depenseDTO){
        DepenseNote depenseNote= new DepenseNote();
        BeanUtils.copyProperties(depenseDTO,depenseNote);
        return depenseNote;
    }

}