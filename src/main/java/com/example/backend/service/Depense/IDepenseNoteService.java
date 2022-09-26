package com.example.backend.service.Depense;

import com.example.backend.dtos.Depense.DepenseDTO;
import com.example.backend.dtos.Depense.NewDepenseDTO;

import java.util.List;

public interface IDepenseNoteService {

    List<DepenseDTO> listDepenseByNoteId(long NoteFraisid);

    DepenseDTO getDepenseByID(long Depenseid);

    NewDepenseDTO saveDepense(long noteFraisId, NewDepenseDTO newDepenseDTO);

    boolean deleteDepense(long depenseId);
}
