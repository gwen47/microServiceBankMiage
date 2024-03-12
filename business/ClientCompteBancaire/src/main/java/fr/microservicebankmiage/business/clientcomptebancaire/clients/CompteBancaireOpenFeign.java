package fr.microservicebankmiage.business.clientcomptebancaire.clients;

import fr.microservicebankmiage.business.clientcomptebancaire.dto.CompteBancaireDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "comptes", url = "http://localhost:8091")
public interface CompteBancaireOpenFeign {

    @GetMapping("/comptes?idClient={idClient}")
    public List<CompteBancaireDto> getComptesByClient(String idClient);

    @PostMapping("/comptes")
    CompteBancaireDto createCompteBancaire(CompteBancaireDto compteBancaire);
}
