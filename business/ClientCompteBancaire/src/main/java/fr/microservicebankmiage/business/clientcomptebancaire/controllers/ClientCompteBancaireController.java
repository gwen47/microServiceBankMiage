package fr.microservicebankmiage.business.clientcomptebancaire.controllers;

import fr.microservicebankmiage.business.clientcomptebancaire.dto.CompteBancaireDto;
import fr.microservicebankmiage.business.clientcomptebancaire.services.ClientCompteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-compte-bancaire")
public class ClientCompteBancaireController {

    private final ClientCompteBancaireService clientCompteBancaireService;

    @Autowired
    public ClientCompteBancaireController(ClientCompteBancaireService clientCompteBancaireService) {
        this.clientCompteBancaireService = clientCompteBancaireService;
    }

    @PostMapping("/comptes")
    public void createCompteBancaire(@RequestBody CompteBancaireDto compteBancaire) {
        clientCompteBancaireService.createCompteBancaire(compteBancaire.getIdClient(), compteBancaire.getNomCompte());
    }

    @DeleteMapping("/clients/{idClient}")
    public void deleteClient(@PathVariable("idClient") String idClient) {
        clientCompteBancaireService.deleteClient(idClient);
    }

}
