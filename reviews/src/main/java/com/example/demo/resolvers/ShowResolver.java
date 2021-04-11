package com.example.demo.resolvers;

import com.example.demo.model.Review;
import com.example.demo.model.Show;
import com.example.demo.services.ReviewService;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowResolver implements GraphQLResolver<Show> {

    @Autowired
    private ReviewService reviewService;

    public List<Review> getReviews(Show show, DataFetchingEnvironment env) {
        return reviewService.getReviews(show);
    }
}
