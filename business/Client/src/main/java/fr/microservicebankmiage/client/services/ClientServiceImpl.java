package fr.microservicebankmiage.client.services;

import fr.microservicebankmiage.client.ClientDto;
import fr.microservicebankmiage.client.entities.Client;
import fr.microservicebankmiage.client.exceptions.ResourceNotFoundException;
import fr.microservicebankmiage.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(@Autowired ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto createClient(String nom, String prenom) {
        Client client = Client.builder().nom(nom).prenom(prenom).build();
        Client savedClient = clientRepository.save(client);
        return ClientDto.builder().id(savedClient.getId()).nom(savedClient.getNom()).prenom(savedClient.getPrenom()).build();
    }

    @Override
    public ClientDto getClient(String id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            throw new ResourceNotFoundException("Client not found");
        }
        return ClientDto.builder().id(client.getId()).nom(client.getNom()).prenom(client.getPrenom()).build();
    }

    @Override
    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElse(null);
        if (client == null) {
            throw new ResourceNotFoundException("Client not found");
        }
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        Client savedClient = clientRepository.save(client);
        return ClientDto.builder().id(savedClient.getId()).nom(savedClient.getNom()).prenom(savedClient.getPrenom()).build();
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(client -> ClientDto.builder().id(client.getId()).nom(client.getNom()).prenom(client.getPrenom()).build()).toList();
    }
}
