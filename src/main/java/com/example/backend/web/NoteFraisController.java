package com.example.backend.web;

import com.example.backend.dtos.NoteFrais.NewNoteFraisDTO;
import com.example.backend.dtos.NoteFrais.NoteFraisDTO;
import com.example.backend.entites.NoteFrais;
import com.example.backend.exception.ConsultantNotFoundException;
import com.example.backend.service.NoteFrais.INoteFraisServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class NoteFraisController {

    @Autowired
    private INoteFraisServiceIMPL noteFraisIMPL;

    @GetMapping("/allnoteFrais/{id}")
    public List<NoteFraisDTO> listNoteFrais(@PathVariable(name="id")Long consultantId){
        return noteFraisIMPL.lisNoteFrais(consultantId);
    }

    @GetMapping("/noteFrais/{id}")
    public NoteFraisDTO getNoteFraisById(@PathVariable(name="id")Long noteFraisId){
        return noteFraisIMPL.getNoteFrais(noteFraisId);
    }

    @PostMapping("/consultant/{id}/NoteFrais")
    public NewNoteFraisDTO saveNoteFrais(
            @PathVariable(name = "id")long consultantId,@RequestBody NewNoteFraisDTO noteFraisDTO
    ) throws ConsultantNotFoundException {
        return noteFraisIMPL.saveNote(consultantId,noteFraisDTO);
    }


    @DeleteMapping("/noteFrais/{id}")
    public void deleteNoteFrais(@PathVariable(name = "id") Long id){
        noteFraisIMPL.deleteNoteFrais(id);
    }
}
