package fr.microservicebankmiage.client.services;

import fr.microservicebankmiage.client.ClientDto;

import java.util.List;

public interface ClientService {
    public ClientDto createClient(String nom, String prenom);
    public ClientDto getClient(String id);
    public void deleteClient(String id);
    public ClientDto updateClient(ClientDto clientDto);

    public List<ClientDto> getAllClients();
}
