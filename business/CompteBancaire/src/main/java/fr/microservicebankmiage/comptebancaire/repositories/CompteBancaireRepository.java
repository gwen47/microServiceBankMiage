package fr.microservicebankmiage.comptebancaire.repositories;

import fr.microservicebankmiage.comptebancaire.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

// Jpa
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {

}
