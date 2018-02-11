package springinaction.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * @author HP
 * @create 2018-02-11-15:29
 */
@Configuration
@EnableMongoRepositories("springinaction.config")
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }

    @Override
    public Mongo mongo() throws Exception {
//        return new MongoClient ();
//      return new MongoClient ("mongodbserver"，port:27017);
//        mongonDB服务器默认端口27017

        MongoCredential credential = MongoCredential.createMongoCRCredential (
                env.getProperty ("mongo.username"),
                "OrdersDB",
                env.getProperty ("mongo.password")
                   .toCharArray ());

        return new MongoClient (
                new ServerAddress ("localhost", 37017),
                Arrays.asList (credential));

    }
}

