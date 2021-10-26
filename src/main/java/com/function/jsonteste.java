package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.json.JSONObject;
//um programa que vai pegar os dados em portugues e devolver em ingles.
//programa com JSONOBJECT
public class jsonteste {
    @FunctionName("jsonteste")
    public HttpResponseMessage run(@HttpTrigger(name = "req", methods = { HttpMethod.POST },
            // metodo aceito vai ser o POST
            route = "jsonteste",

            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        JSONObject json = new JSONObject(request.getBody().get());
        String nome = json.getString("nome");
        String endereco = json.getString("endereco");
        String cep = json.getString("cep");
        String telefone = json.getString("telefone");
        
        if (nome.equals(nome) || (endereco.equals(endereco) || (cep.equals(cep) ||(telefone.equals(telefone) )))) {
            return request.createResponseBuilder(HttpStatus.OK).body(" Data entered " +"\n" + "name:" + nome + "\n"+"address:"+endereco +"\n" +"Zip code:" +cep+ "\n" +"telephone :" +telefone).build();

        } else {
            if (nome.isEmpty())
                return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("Empty field, please type again")
                        .build();
        }
        return null;


    }
}
