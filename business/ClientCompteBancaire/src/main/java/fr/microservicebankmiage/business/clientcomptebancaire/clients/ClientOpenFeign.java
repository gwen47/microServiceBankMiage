package fr.microservicebankmiage.business.clientcomptebancaire.clients;

import fr.microservicebankmiage.business.clientcomptebancaire.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "clients", url = "http://localhost:8090")
public interface ClientOpenFeign {

    @GetMapping("/clients/{id}")
    ClientDto getClient(@PathVariable("id") String idClient);

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable("id") String idClient);


}
