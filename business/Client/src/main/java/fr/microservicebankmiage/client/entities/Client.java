package fr.microservicebankmiage.client.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "clients")
public class Client {

    @Id
    String id;

    @Field
    String nom;

    @Field
    String prenom;

}
