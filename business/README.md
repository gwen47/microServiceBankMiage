# Micro Service

## Runnig a service using maven wrapper
Use the following command within the service directory to run the application using the local maven wrapper:
```shell
./mvnw spring-boot:run
```

## Running tests
Use the following command within the service directory to run the test using the local maven wrapper:
```shell
./mvnw test
```

## Access swagger web interface
After running the application, access the following URL (change port) to see the swagger web interface and test the endpoints:
Change the port to the one used by the desired service.

http://localhost:8090/swagger-ui.html
