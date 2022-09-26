package com.example.backend;

import com.example.backend.entites.Consultant;
import com.example.backend.entites.DepenseNote;
import com.example.backend.entites.NoteFrais;
import com.example.backend.repository.ConsultantRepository;
import com.example.backend.repository.NoteFraisRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

   // @Bean
    CommandLineRunner commandLineRunner(ConsultantRepository consultantRepository,NoteFraisRepository noteFraisRepository) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                Consultant consultant = new Consultant();
                consultant.setNom(name);
                consultant.setEmail(name + "@gmail.com");
                consultant.setPrenom("lanouni");
                consultant.setPassword(name);
                consultantRepository.save(consultant);
                NoteFrais noteFrais = new NoteFrais();
                noteFrais.setDateFrais(new Date());
                noteFrais.setClient("CGI");
                noteFrais.setProjet("note de frais");
                noteFrais.setRemarque("dpojdpoej");
                noteFrais.setConsultant(consultant);
                noteFraisRepository.save(noteFrais);

            });
        };
    }


}
