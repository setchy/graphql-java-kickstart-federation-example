package com.example.demo.query;

import com.example.demo.model.Show;
import com.example.demo.services.ReviewService;
import graphql.execution.UnknownOperationException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReviewsQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ReviewService reviewService;

    public Show get_workaround() {
        throw new UnknownOperationException("Federation workaround");
    }
}
