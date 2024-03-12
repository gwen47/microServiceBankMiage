package fr.microservicebankmiage.business.clientcomptebancaire.services;

import fr.microservicebankmiage.business.clientcomptebancaire.clients.ClientOpenFeign;
import fr.microservicebankmiage.business.clientcomptebancaire.clients.CompteBancaireOpenFeign;
import fr.microservicebankmiage.business.clientcomptebancaire.dto.ClientDto;
import fr.microservicebankmiage.business.clientcomptebancaire.dto.CompteBancaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCompteBancaireServiceImpl implements ClientCompteBancaireService {

    private final CompteBancaireOpenFeign compteBancaireOpenFeign;


    private final ClientOpenFeign clientOpenFeign;

    @Autowired
    public ClientCompteBancaireServiceImpl(CompteBancaireOpenFeign compteBancaireOpenFeign, ClientOpenFeign clientOpenFeign) {
        this.compteBancaireOpenFeign = compteBancaireOpenFeign;
        this.clientOpenFeign = clientOpenFeign;
    }

    @Override
    public CompteBancaireDto createCompteBancaire(String idClient, String nomCompte) {

        ClientDto client = clientOpenFeign.getClient(idClient);

        if (client == null) {
            throw new IllegalStateException("Client not found");
        }

        CompteBancaireDto compteBancaire = CompteBancaireDto.builder()
                .idClient(idClient)
                .nomCompte(nomCompte)
                .build();
        return compteBancaireOpenFeign.createCompteBancaire(compteBancaire);

    }

    @Override
    public void deleteClient(String idClient) {

        // TODO uncomment this code when the compte bancaire service is ready

//        List<CompteBancaireDto> comptes = compteBancaireOpenFeign.getComptesByClient(idClient);
//        if (comptes != null && !comptes.isEmpty()) {
//            throw new IllegalStateException("Client has accounts, delete them first");
//        }

        clientOpenFeign.deleteClient(idClient);

    }
}
