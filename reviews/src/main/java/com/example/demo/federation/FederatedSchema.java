package com.example.demo.federation;

import com.apollographql.federation.graphqljava.Federation;
import com.apollographql.federation.graphqljava._Entity;
import com.example.demo.model.Show;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FederatedSchema {

    @Bean
    public GraphQLSchema customSchema(SchemaParser schemaParser) {
        GraphQLSchema federatedSchema = Federation.transform(schemaParser.makeExecutableSchema())
            .fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName).stream()
                .map(values -> {
                    if ("Show".equals(values.get("__typename"))) {
                        final Object showId = values.get("id");
                        if (showId instanceof String) {
                            return createFederatedTypeShell((String) showId);
                        }
                    }
                    return null;
                })
                .collect(Collectors.toList()))
            .resolveEntityType(env -> {
                final Object src = env.getObject();
                if (src instanceof Show) {
                    return env.getSchema()
                        .getObjectType("Show");
                }
                return null;
            })
            .build();

        return federatedSchema;
    }

    @NotNull
    private static Show createFederatedTypeShell(@NotNull String showId) {
        Show show = new Show();
        show.setId(showId);
        return show;
    }

}


