A GraphQL Java Kickstart / GraphQL Spring Boot federation example, ported from [netflix/dgs-federation-example](https://github.com/Netflix/dgs-federation-example).

The repository contains three separate projects:

1. `shows`: A Java GraphQL service providing the federated `Show` type
2. `reviews`: A Java GraphQL service that extends the `Show` type with `reviews`
3. `apollo-gateway`: An instance of Apollo Server acting as the Federated Gateway

The `shows` and `reviews` projects are Maven projects.
The `apollo-gateway` is a Node project.

Running the demo
----

1. Start `show` by running the Spring Boot app from the IDE
2. Start `reviews` by running the Spring Boot app from the IDE
3. Run `npm install` in the `apollo-gateway` project
4. Run `node index.js` in the `apollo-gateway` project
5. Open http://localhost:4000 for the query editor

The following is a federated query that should work.

```graphql
{
  shows {
    title
    reviews {
      starRating
    }
  }
}
```