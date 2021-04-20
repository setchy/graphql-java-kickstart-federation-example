package com.example.demo.federation;

import com.apollographql.federation.graphqljava._Entity;
import com.example.demo.model.Show;
import graphql.schema.GraphQLSchema;
import com.apollographql.federation.graphqljava.SchemaTransformer;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FederatedSchema {

    @Bean
    public GraphQLSchema federatedGraphQLSchema(SchemaTransformer schemaTransformer)
        throws IOException {
        return schemaTransformer
            .fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName)
                .stream()
                .map(reference -> {
                    if ("Show".equals(reference.get("__typename"))) {
                        return Show.resolveReference(reference);
                    }
                    return null;
                })
                .collect(Collectors.toList()))
            .resolveEntityType(env -> {
                final Object src = env.getObject();
                if (src instanceof Show) {
                    return env.getSchema().getObjectType("Show");
                }
                return null;
            })
            .build();
    }
}


