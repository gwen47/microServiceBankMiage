package fr.microservicebankmiage.comptebancaire.services;

import fr.microservicebankmiage.comptebancaire.CompteBancaireDto;

import java.util.List;

public interface CompteBancaireService {
    public CompteBancaireDto createCompteBancaire(String nom, String prenom);
    public CompteBancaireDto getCompteBancaire(Long id);
    public void deleteCompteBancaire(Long id);
    public CompteBancaireDto updateCompteBancaire(CompteBancaireDto compteBancaireDto);

    public List<CompteBancaireDto> getAllCompteBancaire();
}
