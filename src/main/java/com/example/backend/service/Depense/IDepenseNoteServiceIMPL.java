package com.example.backend.service.Depense;

import com.example.backend.dtos.Depense.DepenseDTO;
import com.example.backend.dtos.Depense.NewDepenseDTO;
import com.example.backend.entites.DepenseNote;
import com.example.backend.entites.NoteFrais;
import com.example.backend.exception.NoteFraisNotFoundException;
import com.example.backend.mappers.Depense.DepenseMapperIMPL;
import com.example.backend.mappers.Depense.NewDepenseMapperIMPL;
import com.example.backend.repository.DepenseNoteRepository;
import com.example.backend.repository.NoteFraisRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class IDepenseNoteServiceIMPL implements IDepenseNoteService{
    @Autowired
    private DepenseNoteRepository depenseNoteRepository;
    @Autowired
    private DepenseMapperIMPL depenseMapper;
    @Autowired
    private NewDepenseMapperIMPL newDepenseMapperIMPL;

    @Autowired
    private NoteFraisRepository noteFraisRepository;

    @Override
    public List<DepenseDTO> listDepenseByNoteId(long NoteFraisid) {
        List<DepenseNote> depenseNotes = depenseNoteRepository.findByNoteFraisId(NoteFraisid);
        List<DepenseDTO> depenseDTOS = depenseNotes.stream().map(cust->depenseMapper.fromDepense(cust)).collect(Collectors.toList());
        return depenseDTOS;
    }

    @Override
    public DepenseDTO getDepenseByID(long Depenseid) {
        DepenseDTO depenseDTO = depenseMapper.fromDepense(depenseNoteRepository.findById(Depenseid).orElse(null));
        return depenseDTO;
    }

    @Override
    public NewDepenseDTO saveDepense(long noteFraisId,NewDepenseDTO newDepenseDTO){
        NoteFrais noteFrais = noteFraisRepository.findById(noteFraisId).orElse(null);
        if (noteFrais== null)
            throw new NoteFraisNotFoundException("note frais n'existe pas");
        DepenseNote depenseNote = newDepenseMapperIMPL.fromDepenseDTO(newDepenseDTO);
        depenseNote.setNoteFrais(noteFrais);
        DepenseNote saveDepenseNote = depenseNoteRepository.save(depenseNote);
        return newDepenseMapperIMPL.fromDepense(saveDepenseNote);
    }

    @Override
    public boolean deleteDepense(long depenseId){
        DepenseDTO depenseDTO = depenseMapper.fromDepense(depenseNoteRepository.findById(depenseId).orElse(null));
        if(depenseDTO == null)
            return false;
        depenseNoteRepository.deleteById(depenseId);
        return true;
    }
}