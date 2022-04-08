# Spring boot microservice example

## Links

-  [Example service](https://github.com/ksereda/Gallery-Service)
-  [Eureka по-русски](https://medium.com/@kirill.sereda/spring-cloud-netflix-eureka-%D0%BF%D0%BE-%D1%80%D1%83%D1%81%D1%81%D0%BA%D0%B8-5b7829481717)
-  [Building Gateway](https://spring.io/guides/gs/gateway/)
-  [Complex Application](https://github.com/microservices-patterns/ftgo-application)
-  [Микросервисная архетектура](https://habr.com/ru/company/milandr/blog/563954/)
-  [Spring Security OAuth2 Resource server](https://habr.com/ru/company/otus/blog/453664/)
-  [Spring Seucurity documentation](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)
-  [Spring Security project](https://www.tutorialspoint.com/spring_boot/spring_boot_oauth2_with_jwt.htm#:~:text=Spring%20Security%20OAuth2%20%E2%88%92%20Implements%20the,Starter%20Web%20%E2%88%92%20Writes%20HTTP%20endpoints.)
- [Spring AMQP documentation](https://docs.spring.io/spring-amqp/docs/current/reference/html/)

## ToDo
-  Centralized auth (Done)
-  Parent pom file (Done)
-  Unit tests (In progress)
-  JDoc (In progress)
-  RabbitMQ integration (Done)
-  Swagger integration (Done)
-  Docker(???) (Nope)

## Archetecture
### Java
 - **Eureka Server** : Eureka service registry
 - **Spring Cloud API Gateway**: API Gateway which is responsible to route the request to specific microservice. Some servies secured through gateway by auth filter. JWT token recipient.
 - **Auth server**: Authentication service. JWT token issuer.
 - **Service-a**: First sample rest web-service. RabbitMQ producer. Requires authorization.
 - **Service-b**: Second sample rest web-service.
 - **Service-ab**: Third sample service. RabbitMQ consumer.

 ### Python
 - **Api-test**: Simple python service. Used to test gateway authentication and services. 
 - **Rest-python-service**: Python FastAPI rest application.