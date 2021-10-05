package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
//chamando as funções do azure

import org.json.JSONObject;
//chamando as funções do JSON 
public class exercicio3 {
    @FunctionName("Exercicio3")
//um programa que deve aceitar o metodo POST que deve verificar o nome dos usuarios e dar uma resposta via HTTP
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.POST},
            //metodo aceito vai ser o POST
            route= "exercicio3",
        
             authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
             final ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");
        JSONObject json=new JSONObject(request.getBody().get());
       //chamando o Json e criando um novo objeto que deve ser respondidio via Body
    
      String nome = json.getString("nome");
      //criando String nome 
        if  (nome.equalsIgnoreCase("joao") || nome.equalsIgnoreCase("João") || nome.equals("joaquin") || nome.equalsIgnoreCase("Joaquin") || nome.equals("jose")|| nome.equalsIgnoreCase("José") ) {
        //só os nomes acima serão aceitos, eles serão aceitos sendo digitados maiusculas ou minusculas 
            return request.createResponseBuilder(HttpStatus.OK).body("seu nome é "+ nome).build();
        //retornara HTTP 200 se o usuario digitar um desses nomes da linha 28
        } else {
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("nome errado digite novamente").build();
        //caso o usuario tenha digitado o nome diferente aparecera HTTP 404
        }

    }
}
    
