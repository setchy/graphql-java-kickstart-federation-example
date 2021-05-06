package com.example.demo.federation;

import com.apollographql.federation.graphqljava.Federation;
import com.apollographql.federation.graphqljava._Entity;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FederatedSchema {

    /**
     * This transformation is not necessary when using Apollo Gateway with Managed Federation. When using Apollo Gateway
     * with an explicit `serviceList` (see apollo-gateway/index.js) it was complaining with the following"
     * <p>
     * Error checking for changes to service definitions: Couldn't load service definitions for "shows" at
     * http://localhost:8080/graphql: Validation error of type FieldUndefined: Field '_service' in type 'Query' is
     * undefined @ '_service'
     */

    @Bean
    public GraphQLSchema customSchema(SchemaParser schemaParser) {
        GraphQLSchema federatedSchema = Federation.transform(schemaParser.makeExecutableSchema())
            .fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName)
                .stream()
                .map(reference -> {
                    return null;
                })
                .collect(Collectors.toList()))
            .resolveEntityType(env -> {
                return null;
            })
            .build();

        return federatedSchema;
    }
}


