package fr.microservicebankmiage.client.controllers;

import fr.microservicebankmiage.client.ClientDto;
import fr.microservicebankmiage.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ClientDto findById(@PathVariable("id") String id) {
        return clientService.getClient(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        clientService.deleteClient(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ClientDto updateById(@PathVariable("id") String id, @RequestBody ClientDto clientDto) {
        clientDto.setId(id);
        return clientService.updateClient(clientDto);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto.getNom(), clientDto.getPrenom());
    }

    @GetMapping(produces = "application/json")
    public List<ClientDto> findAll() {
        return clientService.getAllClients();
    }
}
