package com.example.backend.mappers.NoteFrais;

import com.example.backend.dtos.NoteFrais.NoteFraisDTO;
import com.example.backend.entites.NoteFrais;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NoteFraisMapperIMPL {
    public NoteFraisDTO fromNoteFrais(NoteFrais noteFrais) {
        NoteFraisDTO noteFraisDTO = new NoteFraisDTO();
        BeanUtils.copyProperties(noteFrais,noteFraisDTO);;
        return noteFraisDTO;
    }

    public NoteFrais fromNoteFraisDTO(NoteFraisDTO noteFraisDTO) {
        NoteFrais noteFrais = new NoteFrais();
        BeanUtils.copyProperties(noteFraisDTO,noteFrais);
        return noteFrais;
    }
}