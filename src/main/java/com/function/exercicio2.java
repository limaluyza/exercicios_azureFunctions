package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class exercicio2 {
    @FunctionName("Exercicio2")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.POST},
            route= "exercicio2/{valor}",
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
    
