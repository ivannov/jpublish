package com.vidasoft.jpublish.generator.forge;

import com.vidasoft.jpublish.config.ForgeParameters;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.util.stream.Stream;

@ApplicationScoped
public class ForgeClient {

    private Client client;
    private String baseUri;

    static final class Input {
        private final String name;
        private final String value;

        Input(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    @PostConstruct
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.baseUri = "http://localhost:" + ForgeParameters.PORT + "/api/forge/command";
    }

    void executeCommand(String name, String resource, Input... inputs) {
        client.target(baseUri)
                .path(name)
                .path("execute")
                .request("application/json")
                .post(buildEntity(resource, inputs))
                .close();
    }

    private Entity buildEntity(String resource, Input... inputs) {
        JsonObjectBuilder entityJson = Json.createObjectBuilder();
        entityJson.add("resource", resource);
        entityJson.add("inputs", Stream.of(inputs)
                .map(input -> Json.createObjectBuilder().add("name", input.name).add("value", input.value).build())
                .reduce(Json.createArrayBuilder(), JsonArrayBuilder::add, JsonArrayBuilder::add));
        return Entity.json(entityJson.build());
    }
}
