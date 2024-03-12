package fr.microservicebankmiage.business.clientcomptebancaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientCompteBancaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCompteBancaireApplication.class, args);
    }

}
