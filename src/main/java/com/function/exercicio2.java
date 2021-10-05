package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
//chamar as funções do azure
public class exercicio2 {
//programa para verificar qual número foi digitado na url, é dara uma resposta por Http
@FunctionName("Exercicio2")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.POST},
             //o metodo aceito aqui vai ser o metodo POST
            route= "exercicio2/{valor}",
        
             authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BindingName("valor") Integer valor, 
             //só vai ser aceito números inteiros

             final
             ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");
        if (valor > 5) { 
            //se o valor for maior menor que 5 ele retornara 404
        
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).build();
        } else {
            //se o valor for menor que 5 ele retornara 200
            return request.createResponseBuilder(HttpStatus.OK).body("o valor digitado é " + valor).build();
        }
    }
}
    
