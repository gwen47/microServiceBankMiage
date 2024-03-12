package fr.microservicebankmiage.business.clientcomptebancaire.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {

    String id;

    String nom;

    String prenom;

}
