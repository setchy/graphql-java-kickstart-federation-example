package com.example.demo.query;

import com.example.demo.model.Show;
import com.example.demo.services.ShowsService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShowsQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ShowsService showService;

    public List<Show> getShows() {
        return showService.getShows();
    }
}
