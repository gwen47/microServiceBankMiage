package fr.microservicebankmiage.client;

import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import java.io.IOException;


public class MongoContainerInitialiserTest {

    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @DynamicPropertySource
    static void setPropertiesMongoDBContainer(DynamicPropertyRegistry registry) throws IOException, InterruptedException {

        mongoDBContainer.start();
        mongoDBContainer.execInContainer("mongo", "clients", "--eval", "db.createCollection('clients')");

        String uri = mongoDBContainer.getConnectionString() + "/clients?authSource=admin";

        registry.add("spring.data.mongodb.uri",  () -> uri);
    }

    @BeforeAll
    static void beforeAllMongoDBContainer() {
        mongoDBContainer.start();
    }

    @AfterAll
    static void afterAllMongoDBContainer() {
        mongoDBContainer.stop();
    }

    @AfterEach
    public void afterEachMongoDBContainer() throws IOException, InterruptedException {
        mongoDBContainer.execInContainer( "mongo", "clients", "--eval", "db.clients.drop(); db.createCollection('clients')");
    }
}
