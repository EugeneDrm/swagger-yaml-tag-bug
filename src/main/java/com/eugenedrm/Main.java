package com.eugenedrm;

import com.eugenedrm.model.ConcreteObjectA;
import com.eugenedrm.model.Umbrella;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;

public class Main {
  public static void main(String[] args) throws JsonProcessingException {
    Umbrella exampleValue = new Umbrella(new ConcreteObjectA("x"));
    OpenAPI openApi = new OpenAPI()
        .components(new Components().addExamples("umbrellaExample", new Example().value(exampleValue)));

    String result = Yaml.mapper().writeValueAsString(openApi);
    System.out.println(result);
  }
}
