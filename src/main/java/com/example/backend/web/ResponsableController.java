package com.example.backend.web;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Responsable.ResponsableDTO;
import com.example.backend.dtos.Responsable.ResponsableInscriptionDTO;
import com.example.backend.entites.Consultant;
import com.example.backend.entites.Responsable;
import com.example.backend.exception.ConsultantNotFoundException;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.ResponsableRepository;
import com.example.backend.service.Responsable.IResponsableServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ResponsableController {
    @Autowired
    private IResponsableServiceIMPL iResponsableServiceIMPl;

    @Autowired
    private ResponsableRepository responsableRepository;

    @PostMapping("login/responsable")
    public ResponseEntity<?> loginConsultant(@RequestBody ResponsableDTO responsableDTO) throws ConsultantNotFoundException {
        Responsable responsable = responsableRepository.findByEmailAndPassword(responsableDTO.getEmail(),responsableDTO.getPassword());
        if (responsable != null)
        {
            System.out.println(responsable.getEmail());
            return ResponseEntity.ok(responsable);

        }

        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @GetMapping("/responsables")
    public List<ResponsableDTO> listResponsable(){
        return iResponsableServiceIMPl.listResponsables();
    }

    @GetMapping("/responsable/{id}")
    public ResponsableDTO getResponsableById(@PathVariable (name="id")Long responsableID){
        return iResponsableServiceIMPl.getResponsable(responsableID);
    }

    @PostMapping("/responsable")
    public ResponsableInscriptionDTO saveResponsable(@RequestBody ResponsableInscriptionDTO responsable){
        return  iResponsableServiceIMPl.saveResponsable(responsable);
    }

    @DeleteMapping("responsable/{id}")
    public void deleteResponsable(@PathVariable(name = "id") Long id){
        iResponsableServiceIMPl.deleteResponsable(id);
    }

    @GetMapping("listConsultant/{id}")
    public List<ConsultantDTO> listConsultant(@PathVariable(name = "id")Long id){
        return iResponsableServiceIMPl.listConsultant(id);
    }



}