package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
//Chamando as funções do azure 
import org.json.JSONObject;
//chamando as funções do JSON
public class exercicio4n {
    @FunctionName("Exercicio4")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = { HttpMethod.POST }, route = "exercicio4",
//o metodo aceito sera o metodo POST 
//um programa para verificar se o usuario o nome digitado pelo usuario com algumas regras 
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
         final
          ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");
        JSONObject json = new JSONObject(request.getBody().get());
        
        String nome = json.getString("nome");
     //criando uma String nome com o json
        String userIdentifier = request.getHeaders().get("useridentifier");
        //na url da pagina o usuario deve escrever "useridentifiquer" para continuar ou então dara erro 401
        if (userIdentifier.equals("azurefunctions")) {
    //na url da pagina o usuario deve escrever "azurefunction" para continuar ou então dara erro 401

            if  (nome.equalsIgnoreCase("João") || nome.equals("joaquin") ||nome.equalsIgnoreCase("José") ) {
    //se ele digitou certo na linha 26 ele deve escrever um dos nomes acima para continuar, esse programa é case sensitive 
                return request.createResponseBuilder(HttpStatus.OK).build();
    //se ele digitou certo retorna HTTP 200

            } else {
                return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("nome errado digite novamente").build();

            }
// se ele digitou errado retorna 404 
        } else {
            return request.createResponseBuilder(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
