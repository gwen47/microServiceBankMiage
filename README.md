# Cloud Micro-services and DevOps Project Master MIAGE

This project is a part of the Master MIAGE at the University of Paul Sabatier Toulouse France. 
It aims to provide a complete example of a micro-services architecture using the following technologies:
- Spring Boot for the micro-services
- Spring Cloud for the edge services 
- Docker for the containerization
- Ansible for the deployment
- Terraform for the infrastructure provisioning on Azure

The project is divided into 3 main parts:
- The business micro-services
- The edge services
- The infrastructure

The business micro-services are the core of the application. They are the services that provide the business logic and the data.
The edge services are the services that provide the entry point to the application. They are the services that are exposed to the outside world.
The infrastructure is the part of the project that is responsible for the deployment of the application. It is responsible for the provisioning of the infrastructure and the deployment of the application.

## Business Micro-services
- [Client](business/Client/README.md) (Spring Boot, MongoDB)
- [CompteBancaire](business/CompteBancaire/README.md) (Spring Boot, MySQL)
- [ClientCompteBancaire](business/ClientCompteBancaire/README.md) (Spring Boot, Feign)

### Client
The client micro-service is responsible for the management of the clients. 
It uses a MongoDB database to store the clients.

### CompteBancaire
The CompteBancaire micro-service is responsible for the management of the bank accounts.
It uses a MySQL database to store the bank accounts.

### ClientCompteBancaire
The ClientCompteBancaire micro-service is a composite micro-service that is responsible for the management of the relationship between the clients and the bank accounts.
It rely on the Client and CompteBancaire micro-services to provide its functionality and doesn't have its own database.

## Edge Services
- [Feign](edge/Feign/README.md) for declarative REST client
- [Gateway](edge/Gateway/README.md) (Spring Cloud) for the API Gateway
- [Eureka](edge/Eureka/README.md) for service discovery
- [Config](edge/Config/README.md) (Spring Cloud Config) for externalized configuration
- [Keycloak](edge/Keycloak/README.md) for authentication and authorization
- [Graphana](edge/Graphana/README.md) for monitoring and observability
- [Zipkin](edge/Zipkin/README.md) for distributed tracing

