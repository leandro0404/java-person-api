# api-person

## JPA Attribute Encryption

This project includes a demonstration of using JPA (Java Persistence API) with attribute encryption. The goal is to encrypt a specific field before saving it in the database and decrypt it when reading it through the application.

In the example provided in this demo, the `motherName` field is encrypted and stored in the database. The encryption is achieved by using the `@Convert` annotation with the `AttributeEncryptor` class, which handles the encryption and decryption logic.

Here's an example of how the encryption is applied to the `motherName` field:

```java
@Column
@Convert(converter = AttributeEncryptor.class)
private String motherName;
```



#### Context Diagram - Api person

![context-diagram.png](docs/diagram/c4-model/images/context.svg)


---

### Local setup

#### Install tools

- Java 17
- Maven 3
- [SDKMAN!](https://sdkman.io/install)


#### Build

```shell
mvn clean install -DskipTests
```

#### Test

```shell
mvn test -Dspring.profiles.active=test
```

#### Run

```shell
mvn spring-boot:run -Dspring-boot.run.profiles=staging -Dserver.port=8080
```


# java-person-api
