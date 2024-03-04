package fr.microservicebankmiage.comptebancaire.entities;


import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CompteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    String nom;

    @Column(name = "prenom", nullable = false)
    String prenom;

}
