package fr.microservicebankmiage.business.clientcomptebancaire.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompteBancaireDto {

    Long id;
    String idClient;

    String nomCompte;

    Long solde;

}
