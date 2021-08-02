## Validador de senha

#### Para executar aplicação após o clone executar:
    Buid: mvn clean install
#### Após a conclusão ir na parta target e executar:
    Run App: java -jar passcheck-0.0.1-SNAPSHOT.jar

#### Tambem é possivel executar a aplicação via Docker via Dockerfile
    docker buid -t passcheck . 

#### Para inicar os teste pode utilizar a collection do Postman ou o Swagger
    Passcheck.postman_collection.json
    http://localhost:8080/swagger-ui.html#/passcheck-controller/