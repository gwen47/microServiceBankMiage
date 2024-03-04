package fr.microservicebankmiage.client;

import fr.microservicebankmiage.client.entities.Client;
import fr.microservicebankmiage.client.repositories.ClientRepository;
import fr.microservicebankmiage.client.services.ClientService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientIntegrationTest extends MongoContainerInitialiserTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Autowired
    private ClientRepository clientRepository;


    @Test
    void getAllClients() {
        Client client1 = clientRepository.save(Client.builder().nom("nom1").prenom("prenom1").build());
        Client client2 = clientRepository.save(Client.builder().nom("nom2").prenom("prenom2").build());

        given()
                .when()
                .get("/clients")
                .then()
                .statusCode(200)
                // body contains the two clients ids
                .body("id", hasItem(client1.getId())).
                body("id", hasItem(client2.getId()));
    }

    @Test
    void getClientById() {
        Client client1 = clientRepository.save(Client.builder().nom("nom1").prenom("prenom1").build());

        given()
                .when()
                .get("/clients/" + client1.getId())
                .then()
                .statusCode(200)
                .body("id", is(client1.getId()));
    }

    @Test
    void createClient() {
        String id = given()
                .contentType("application/json")
                .body("{\"nom\": \"nom1\", \"prenom\": \"prenom1\"}")
                .when()
                .post("/clients")
                .then()
                .statusCode(201)
                // contains the created client id
                .body("$", hasKey("id"))
                .body("nom", is("nom1"))
                .body("prenom", is("prenom1")).extract().response().jsonPath().getString("id");

        Client client = clientRepository.findById(id).orElse(null);
        assert client != null;
        assert client.getNom().equals("nom1");
        assert client.getPrenom().equals("prenom1");
    }

    @Test
    void updateClient() {
        Client client1 = clientRepository.save(Client.builder().nom("nom1").prenom("prenom1").build());

        given()
                .contentType("application/json")
                .body("{\"nom\": \"nom2\", \"prenom\": \"prenom2\"}")
                .when()
                .put("/clients/" + client1.getId())
                .then()
                .statusCode(200)
                .body("id", is(client1.getId()))
                .body("nom", is("nom2"))
                .body("prenom", is("prenom2"));

        Client client = clientRepository.findById(client1.getId()).orElse(null);
        assert client != null;
        assert client.getNom().equals("nom2");
        assert client.getPrenom().equals("prenom2");
    }

    @Test
    void deleteClient() {
        Client client1 = clientRepository.save(Client.builder().nom("nom1").prenom("prenom1").build());

        given()
                .when()
                .delete("/clients/" + client1.getId())
                .then()
                .body(is(""))
                .statusCode(204);

        assert clientRepository.findById(client1.getId()).isEmpty();
    }

    @Test
    void getClientByIdNotFound() {
        given()
                .when()
                .get("/clients/123")
                .then()
                .statusCode(404);
    }

    @Test
    void updateClientNotFound() {
        given()
                .contentType("application/json")
                .body("{\"nom\": \"nom2\", \"prenom\": \"prenom2\"}")
                .when()
                .put("/clients/123")
                .then()
                .statusCode(404);
    }

}
