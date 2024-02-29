package luis.cavalcante.sistemabancario.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoDatabaseFactory mongoConfigure() {
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/banksystem");
    }

//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate();
//    }
}
