package lexicon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "lexicon.entity")
public class JPAWorkshop {

    public static void main(String[] args) {
        SpringApplication.run(JPAWorkshop.class, args);
    }
}