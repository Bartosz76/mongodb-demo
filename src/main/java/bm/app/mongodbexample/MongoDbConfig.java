package bm.app.mongodbexample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
        Article article = new Article();
        article.setAuthor("Vargothan Ganlinzarak");
        article.setTitle("Forge with your heart, not hands.");

        Comment commentOne = new Comment();
        commentOne.setText("Good lad.");
        Comment commentTwo = new Comment();
        commentTwo.setText("I could hardly stay calm reading this wisdom.");

        article.setCommentList(Arrays.asList(commentOne, commentTwo));

        mongoTemplate.insert(article);

        /**
         * Below means I want to get all Articles.
         */
        List<Article> all = mongoTemplate.findAll(Article.class);

        System.out.println(all);
    }

}
