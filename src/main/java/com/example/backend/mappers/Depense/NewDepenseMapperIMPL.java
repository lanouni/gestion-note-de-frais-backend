package com.example.backend.mappers.Depense;

import com.example.backend.dtos.Depense.DepenseDTO;
import com.example.backend.dtos.Depense.NewDepenseDTO;
import com.example.backend.entites.DepenseNote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NewDepenseMapperIMPL {

    public NewDepenseDTO fromDepense(DepenseNote  depenseNote){
        NewDepenseDTO depenseDTO= new NewDepenseDTO();
        BeanUtils.copyProperties(depenseNote,depenseDTO);
        return depenseDTO;
    }

    public DepenseNote fromDepenseDTO(NewDepenseDTO  depenseDTO){
        DepenseNote depenseNote= new DepenseNote();
        BeanUtils.copyProperties(depenseDTO,depenseNote);
        return depenseNote;
    }

}