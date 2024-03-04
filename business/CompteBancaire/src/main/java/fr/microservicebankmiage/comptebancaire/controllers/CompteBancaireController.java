package fr.microservicebankmiage.comptebancaire.controllers;

import fr.microservicebankmiage.comptebancaire.CompteBancaireDto;
import fr.microservicebankmiage.comptebancaire.services.CompteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptesbancaires")
public class CompteBancaireController {

    private final CompteBancaireService compteBancaireService;

    @Autowired
    public CompteBancaireController(CompteBancaireService compteBancaireService) {
        this.compteBancaireService = compteBancaireService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public CompteBancaireDto findById(@PathVariable("id") Long id) {
        return compteBancaireService.getCompteBancaire(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        compteBancaireService.deleteCompteBancaire(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public CompteBancaireDto updateById(@PathVariable("id") Long id, @RequestBody CompteBancaireDto compteBancaireDto) {
        compteBancaireDto.setId(id);
        return compteBancaireService.updateCompteBancaire(compteBancaireDto);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CompteBancaireDto create(@RequestBody CompteBancaireDto clientDto) {
        return compteBancaireService.createCompteBancaire(clientDto.getNom(), clientDto.getPrenom());
    }

    @GetMapping(produces = "application/json")
    public List<CompteBancaireDto> findAll() {
        return compteBancaireService.getAllCompteBancaire();
    }
}
