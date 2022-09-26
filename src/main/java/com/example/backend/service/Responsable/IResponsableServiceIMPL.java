package com.example.backend.service.Responsable;

import com.example.backend.dtos.Consultant.ConsultantDTO;
import com.example.backend.dtos.Responsable.ResponsableDTO;
import com.example.backend.dtos.Responsable.ResponsableInscriptionDTO;
import com.example.backend.entites.Consultant;
import com.example.backend.entites.Responsable;
import com.example.backend.exception.ResponsableNotFoundException;
import com.example.backend.mappers.Consultant.ConsultantMapperImpl;
import com.example.backend.mappers.Responsable.ResponsableInscriptionMapperImpl;
import com.example.backend.mappers.Responsable.ResponsableMapperImpl;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.ResponsableRepository;
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
public class IResponsableServiceIMPL implements IResponsableService{

    @Autowired
    private ResponsableRepository responsableRepository;
    @Autowired
    private ResponsableMapperImpl responsableMapper;
    @Autowired
    private ResponsableInscriptionMapperImpl inscriptionDTO;

    @Autowired
    private ConsultantRepository consultantRepository;
    @Autowired
    private ConsultantMapperImpl consultantMapper;

    @Override
    public List<ResponsableDTO> listResponsables() {
        List<Responsable> responsables = responsableRepository.findAll();
        List<ResponsableDTO> responsableDTOS = responsables.stream().map(cust -> responsableMapper.fromResponsable(cust)).collect(Collectors.toList());
        return responsableDTOS ;
    }

    @Override
    public ResponsableDTO getResponsable(long id) {
        Responsable responsable = responsableRepository.findById(id).
                orElseThrow(()->new ResponsableNotFoundException("responsable not found"));
        return responsableMapper.fromResponsable(responsable);
    }

    @Override
    public ResponsableInscriptionDTO saveResponsable(ResponsableInscriptionDTO responsable) {
        Responsable responsable1= inscriptionDTO.fromResponsableDTO(responsable);
        Responsable saveResponsable = responsableRepository.save(responsable1);
        return inscriptionDTO.fromResponsable(saveResponsable);
    }

    @Override
    public void deleteResponsable(Long id){
        responsableRepository.deleteById(id);
    }

    @Override
    public List<ConsultantDTO> listConsultant(Long id){
        List<Consultant> consultants= consultantRepository.findByResponsableId(id);
        List<ConsultantDTO> consultantDTOS= consultants.stream().map(cust->consultantMapper.fromConsultant(cust)).collect(Collectors.toList());
        return consultantDTOS;
    }

}