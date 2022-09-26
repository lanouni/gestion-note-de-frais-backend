package com.example.backend.web;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Consultant.ConsultantInscriptionDTO;
import com.example.backend.entites.Consultant;
import com.example.backend.exception.ConsultantNotFoundException;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.service.Consultant.IConsultantServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ConsultantController {

    @Autowired
    private IConsultantServiceIMPL iConsultantServiceIMPL;
    @Autowired
    private ConsultantRepository consultantRepository;

    @GetMapping("/consultants")
    public List<ConsultantDTO> listconConsultants(){
        return iConsultantServiceIMPL.listConsultants();
    }


    @PostMapping("/consultant/login")
    public ResponseEntity<?> loginConsultant(@RequestBody ConsultantDTO consultant) throws ConsultantNotFoundException{
        Consultant consultant1 = consultantRepository.findByEmailAndPassword(consultant.getEmail(),consultant.getPassword());
        if (consultant1 != null)
        {
            System.out.println(consultant.getEmail());
            return ResponseEntity.ok(consultant1);

        }

        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @GetMapping("/consultant/{id}")
    public  ConsultantDTO getConsultantById(@PathVariable(name="id")Long consultantId) throws ConsultantNotFoundException {
        return iConsultantServiceIMPL.getConsultant(consultantId);
    }

    @GetMapping("/consultantByEmail")
    public  long getConsultantByEmail(@RequestBody String consultantDTO) throws ConsultantNotFoundException {
        System.out.println("email : " + consultantDTO);
        long id =  iConsultantServiceIMPL.getConsultantbyEmail(consultantDTO).getId();
        System.out.println(id);
        return id;
    }

    @PostMapping("/consultant")
    public ConsultantInscriptionDTO saveConsultant(@RequestBody ConsultantInscriptionDTO consultant){
        return iConsultantServiceIMPL.saveConsultanta(consultant);
    }

    @DeleteMapping("/consultant/{id}")
    public void deleteConsultant(@PathVariable(name = "id") Long id){
        iConsultantServiceIMPL.deleteConsultant(id);
    }
}