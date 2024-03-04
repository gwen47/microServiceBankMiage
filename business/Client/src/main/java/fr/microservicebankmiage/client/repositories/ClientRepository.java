package fr.microservicebankmiage.client.repositories;

import fr.microservicebankmiage.client.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ClientRepository extends MongoRepository<Client, String> {

}
