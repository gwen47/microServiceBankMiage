package fr.microservicebankmiage.comptebancaire.services;


import fr.microservicebankmiage.comptebancaire.CompteBancaireDto;
import fr.microservicebankmiage.comptebancaire.entities.CompteBancaire;
import fr.microservicebankmiage.comptebancaire.exceptions.ResourceNotFoundException;
import fr.microservicebankmiage.comptebancaire.repositories.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteBancaireServiceImpl implements CompteBancaireService {

    private final CompteBancaireRepository compteBancaireRepository;

    public CompteBancaireServiceImpl(@Autowired CompteBancaireRepository compteBancaireRepository) {
        this.compteBancaireRepository = compteBancaireRepository;
    }

    @Override
    public CompteBancaireDto createCompteBancaire(String nom, String prenom) {
        CompteBancaire compteBancaire = CompteBancaire.builder().nom(nom).prenom(prenom).build();
        CompteBancaire savedCompteBancaire = compteBancaireRepository.save(compteBancaire);
        return CompteBancaireDto.builder().id(compteBancaire.getId()).nom(compteBancaire.getNom()).prenom(compteBancaire.getPrenom()).build();
    }

    @Override
    public CompteBancaireDto getCompteBancaire(Long id) {
        CompteBancaire compteBancaire = compteBancaireRepository.findById(id).orElse(null);
        if (compteBancaire == null) {
            throw new ResourceNotFoundException("Compte Bancaire not found");
        }
        return CompteBancaireDto.builder().id(compteBancaire.getId()).nom(compteBancaire.getNom()).prenom(compteBancaire.getPrenom()).build();
    }

    @Override
    public void deleteCompteBancaire(Long id) {
        compteBancaireRepository.deleteById(id);
    }

    @Override
    public CompteBancaireDto updateCompteBancaire(CompteBancaireDto compteBancaireDto) {
        CompteBancaire compteBancaire = compteBancaireRepository.findById(compteBancaireDto.getId()).orElse(null);
        if (compteBancaire == null) {
            throw new ResourceNotFoundException("CompteBancaire not found");
        }
        compteBancaire.setNom(compteBancaireDto.getNom());
        compteBancaire.setPrenom(compteBancaireDto.getPrenom());
        CompteBancaire savedCompteBancaire = compteBancaireRepository.save(compteBancaire);
        return CompteBancaireDto.builder().id(savedCompteBancaire.getId()).nom(savedCompteBancaire.getNom()).prenom(savedCompteBancaire.getPrenom()).build();
    }

    @Override
    public List<CompteBancaireDto> getAllCompteBancaire() {
        return compteBancaireRepository.findAll().stream().map(compteBancaire -> CompteBancaireDto.builder().id(compteBancaire.getId()).nom(compteBancaire.getNom()).prenom(compteBancaire.getPrenom()).build()).toList();
    }
}
