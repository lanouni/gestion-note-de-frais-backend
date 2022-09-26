package com.example.backend.web;


import com.example.backend.dtos.Depense.DepenseDTO;
import com.example.backend.dtos.Depense.NewDepenseDTO;
import com.example.backend.dtos.NoteFrais.NewNoteFraisDTO;
import com.example.backend.service.Depense.IDepenseNoteServiceIMPL;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class DepenseNoteController {
    @Autowired
    private IDepenseNoteServiceIMPL iDepenseNoteServiceIMPL;

    @GetMapping("/ListDepensebyID/{id}")
    public List<DepenseDTO> depenseListByNote(@PathVariable(name="id")Long NoteID){
        return iDepenseNoteServiceIMPL.listDepenseByNoteId(NoteID);
    }

    @GetMapping("/DepensebyID/{id}")
    public DepenseDTO getDepenseById(@PathVariable(name="id")Long depenseID){
        return iDepenseNoteServiceIMPL.getDepenseByID(depenseID);
    }

    @PostMapping("/noteFrais/{id}/Depense")
    public NewDepenseDTO saveDepense(@PathVariable(name = "id")long noteFraisId, @RequestBody NewDepenseDTO newDepenseDTO){
        return iDepenseNoteServiceIMPL.saveDepense(noteFraisId,newDepenseDTO);
    }

    @DeleteMapping("/delete/depense/{id}")
    public void deleteDepense(@PathVariable(name = "id")long depenseId ){
        iDepenseNoteServiceIMPL.deleteDepense(depenseId);
    }
}