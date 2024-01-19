// Pacote
package apiTest;
// Bibliotecas


import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


// Classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TesteBookStore {
    // Atributos
    // Uso Comum
    Gson gson = new Gson(); // instancia o Gson - mantem um json

    static String ct = "application/json";
    static String jsonBody;

    // EndPoints
    static String uriAccount = "https://bookstore.toolsqa.com/Account/v1/";

    // Dados da Conta / Account
    static  String userName = "barreto3";
    static String password = "Senha@23";
    static String userId;
    static String token;

    @Test
    @Order(1)
    public void testeCriarUsuario(){
        // Configura
        EntityAccount entityAccount = new EntityAccount(); // instancia a classe
        entityAccount.userName = userName;
        entityAccount.password = password;

        jsonBody = gson.toJson(entityAccount);

        // Executa
        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "User")
        // Valida
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(userName))
                .extract()
        ;
        userId = resp.jsonPath().getString("userID");
        System.out.println("userId: " + userId);


    }

    @Test
    @Order(2)
    public void testarTokenUser(){
        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
        .extract()
        ;
        token = resp.jsonPath().getString("token");
        System.out.println("token: " + token);

    }

    @Test
    @Order(66)
    public void testeExcluirUsuario(){
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uriAccount + "user/" + userId)
        .then()
                .statusCode(204)
        ;
    }

}
