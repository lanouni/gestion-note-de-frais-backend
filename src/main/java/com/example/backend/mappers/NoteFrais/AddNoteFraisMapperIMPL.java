package com.example.backend.mappers.NoteFrais;

import com.example.backend.dtos.NoteFrais.NewNoteFraisDTO;
import com.example.backend.dtos.NoteFrais.NoteFraisDTO;
import com.example.backend.entites.NoteFrais;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AddNoteFraisMapperIMPL {
    public NewNoteFraisDTO fromNoteFrais(NoteFrais noteFrais) {
        NewNoteFraisDTO noteFraisDTO = new NewNoteFraisDTO();
        BeanUtils.copyProperties(noteFrais,noteFraisDTO);;
        return noteFraisDTO;
    }

    public NoteFrais fromNoteFraisDTO(NewNoteFraisDTO noteFraisDTO) {
        NoteFrais noteFrais = new NoteFrais();
        BeanUtils.copyProperties(noteFraisDTO,noteFrais);
        return noteFrais;
    }
}