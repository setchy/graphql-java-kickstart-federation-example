const { ApolloServer } = require('apollo-server');
const { ApolloGateway } = require('@apollo/gateway')

const gateway = new ApolloGateway({
    serviceList: [
        { name: 'shows', url: 'http://localhost:8080/graphql' },
        { name: 'reviews', url: 'http://localhost:8081/graphql' },
    ]
});

const server = new ApolloServer({
    gateway,
});


server.listen();

console.log(`🚀 Apollo Gateway now ready at http://localhost:4000/graphql`);