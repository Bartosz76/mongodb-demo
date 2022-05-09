package bm.app.mongodbexample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @Component means the class will be managed by Spring Context.
 */
@Component
public class MongoDbConfig {

    /**
     * A bean for the Spring Context that will allow me to talk to the database. Every interaction will be based on
     * it.
     */
    private MongoTemplate mongoTemplate;

    public MongoDbConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @EventListener allows for the method to be triggered upon the execution of the application.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        
    }

}
