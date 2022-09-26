package com.example.backend.service.Consultant;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Consultant.ConsultantInscriptionDTO;
import com.example.backend.entites.Consultant;
import com.example.backend.exception.ConsultantNotFoundException;
import com.example.backend.mappers.Consultant.ConsultantInscriptionMapperImpl;
import com.example.backend.mappers.Consultant.ConsultantMapperImpl;
import com.example.backend.repository.ConsultantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class IConsultantServiceIMPL implements IConsultantService {
    @Autowired
    private ConsultantRepository consultantRepository;
    @Autowired
    private ConsultantMapperImpl consultantMapper;

    @Autowired
    private ConsultantInscriptionMapperImpl consul;

    @Override
    public List<ConsultantDTO> listConsultants() {
        List<Consultant> listConsultant= consultantRepository.findAll();
        List<ConsultantDTO> listConsultantDTOS = listConsultant.stream().map(cust -> consultantMapper.fromConsultant(cust)).collect(Collectors.toList());
        return listConsultantDTOS;
    }

    @Override
    public ConsultantDTO getConsultant(Long id) throws ConsultantNotFoundException {
        Consultant consultant = consultantRepository.findById(id).orElseThrow(()->new ConsultantNotFoundException());
        return consultantMapper.fromConsultant(consultant);
    }



    @Override
    public ConsultantDTO getConsultantbyEmail(String email) throws ConsultantNotFoundException {
        Consultant consultant = consultantRepository.findByEmail(email);
        return consultantMapper.fromConsultant(consultant);
    }

    @Override
    public ConsultantInscriptionDTO saveConsultanta(ConsultantInscriptionDTO inscriptionDTO) {
        Consultant consultant = consul.fromConsultantDTO(inscriptionDTO);
        Consultant saveconsultant = consultantRepository.save(consultant);
        return consul.fromConsultant(saveconsultant);
    }

    @Override
    public void deleteConsultant(Long Id){
        consultantRepository.deleteById(Id);
    }

}