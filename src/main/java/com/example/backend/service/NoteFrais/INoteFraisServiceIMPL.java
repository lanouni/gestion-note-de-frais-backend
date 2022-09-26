package com.example.backend.service.NoteFrais;

import com.example.backend.dtos.NoteFrais.NewNoteFraisDTO;
import com.example.backend.dtos.NoteFrais.NoteFraisDTO;
import com.example.backend.entites.Consultant;
import com.example.backend.entites.NoteFrais;
import com.example.backend.exception.ConsultantNotFoundException;
import com.example.backend.exception.NoteFraisNotFoundException;
import com.example.backend.mappers.NoteFrais.AddNoteFraisMapperIMPL;
import com.example.backend.mappers.NoteFrais.NoteFraisMapperIMPL;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.NoteFraisRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class INoteFraisServiceIMPL implements  INoteFraisService{
    @Autowired
    private NoteFraisRepository noteFraisRepository;
    @Autowired
    private NoteFraisMapperIMPL noteFraisMapperIMPL;
    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    private AddNoteFraisMapperIMPL addNoteFraisMapperIMPL;

    @Override
    public List<NoteFraisDTO> lisNoteFrais(long Id) {
        List<NoteFrais> noteFrais = noteFraisRepository.findByConsultantId(Id);
        List<NoteFraisDTO> noteFraisDTOS = noteFrais.stream().map(cust->noteFraisMapperIMPL.fromNoteFrais(cust)).collect(Collectors.toList());
        if (noteFrais == null) throw new NoteFraisNotFoundException("note Frais Not found");
        return noteFraisDTOS;
    }

    @Override
    public NoteFraisDTO getNoteFrais(long id) {
        NoteFrais noteFrais = noteFraisRepository.findById(id).orElseThrow(()->new NoteFraisNotFoundException("not found"));
        return noteFraisMapperIMPL.fromNoteFrais(noteFrais);
    }

    @Override
    public NewNoteFraisDTO saveNote(long consultantId,NewNoteFraisDTO noteFraisDTO) throws ConsultantNotFoundException {
        Consultant consultant = consultantRepository.findById(consultantId).orElse(null);
        if (consultant == null)
            throw new ConsultantNotFoundException();
        NoteFrais noteFrais = addNoteFraisMapperIMPL.fromNoteFraisDTO(noteFraisDTO);
        noteFrais.setConsultant(consultant);
        NoteFrais saveNoteFrais = noteFraisRepository.save(noteFrais);
        return addNoteFraisMapperIMPL.fromNoteFrais(saveNoteFrais);
    }

    @Override
    public void deleteNoteFrais(Long id){
        consultantRepository.deleteById(id);
    }
}