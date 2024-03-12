package fr.microservicebankmiage.business.clientcomptebancaire.services;

import fr.microservicebankmiage.business.clientcomptebancaire.dto.CompteBancaireDto;

public interface ClientCompteBancaireService {
    CompteBancaireDto createCompteBancaire(String idClient, String nomCompte);

    void deleteClient(String idClient);
}
