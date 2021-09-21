package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Exercicio1 {
    /**
     * This function listens at endpoint "/api/Exercicio1". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Exercicio1
     * 2. curl {your host}/api/Exercicio1?name=HTTP%20Query
     */
    @FunctionName("Exercicio1")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.GET},
            route= "exercicio1/{valor}",
             authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BindingName("valor") Integer valor, 
             final
             ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");



       
        if (valor > 5) {
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body("o valor é" + valor).build();
        }
    }
}
