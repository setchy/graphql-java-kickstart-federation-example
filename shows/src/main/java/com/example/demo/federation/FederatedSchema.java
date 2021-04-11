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
     * I dont believe the following is needed when using Apollo Gateway with Managed Federation.
     * When using Apollo Gateway with `serviceList` it was complaining with the following
     *
     * Error checking for changes to service definitions: Couldn't load service definitions for "shows" at http://localhost:8080/graphql:
     * Validation error of type FieldUndefined: Field '_service' in type 'Query' is undefined @ '_service'
     *
     */

    @Bean
    public GraphQLSchema customSchema(SchemaParser schemaParser) {
        GraphQLSchema federatedSchema = Federation.transform(schemaParser.makeExecutableSchema())
            .fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName).stream()
                .map(values -> {
//                    if ("Show".equals(values.get("__typename"))) {
//                        final Object showId = values.get("id");
//                        if (showId instanceof String) {
//                            return createFederatedTypeShell((String) showId);
//                        }
//                    }
                    return null;
                })
                .collect(Collectors.toList()))
            .resolveEntityType(env -> {
//                final Object src = env.getObject();
//                if (src instanceof Show) {
//                    return env.getSchema()
//                        .getObjectType("Show");
//                }
                return null;
            })
            .build();

        return federatedSchema;
    }
}


