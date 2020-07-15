# Unwanted YAML tag in OpenAPI YAML

## Overview
This example shows how a bug with YAML tag when serializing OpenAPI with example(s) into YAML.

## Issue
The project contains a small code snippet that serializes `OpenAPI` instance into YAML:
```yaml
openapi: 3.0.1
components:
  examples:
    umbrellaExample:
      value:
        object: !<Type A>
          type: TYPE_A
          name: x
          description: "y"
```

`!<Type A>` doesn't seem to be a valid tag hare.
Swagger Online Editor tool also complains about this tag and refuses to render files with such tags.

## Using this example project
Run class `Main` and see console output.

## Key notes
The issue appears when:
- there's an abstract class (`AbstractObject`) with one or more concrete implementations
- the abstract class (`AbstractObject`) has a `type` field
- annotation `@JsonTypeInfo` is used on the abstract class (`AbstractObject`) to properly deserialize concrete implementation(s) into abstract reference
- there's a model class (`Umbrella`) which references the abstract class (`AbstractObject`)
- an example object for model class (`Umbrella`) is defined in OpenAPI `components/examples` section via OpenAPI bean (see `Application#openApi`)
