package fr.microservicebankmiage.comptebancaire;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompteBancaireDto {

    Long id;

    String nom;

    String prenom;

}
